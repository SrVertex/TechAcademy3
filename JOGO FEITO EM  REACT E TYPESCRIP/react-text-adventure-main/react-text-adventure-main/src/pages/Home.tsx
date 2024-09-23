import {
  Box,
  Button,
  Flex,
  Input,
  InputGroup,
  InputRightElement,
  Kbd,
} from "@chakra-ui/react";
import gameFile from "../file/game.json";
import TextDisplay from "../components/TextDisplay";
import { useRef, useState } from "react";

type SceneObject = {
  idObject: number;
  possibleToCarry: boolean;
  objectName: string;
  objectDescription: string;
  positiveResult: string;
  negativeResult?: string;
  correctCommand?: string;
  targetScene: number;
  solved: boolean;
  got: boolean;
};

type Scene = {
  idScene: number;
  title: string;
  description: string;
  objects?: SceneObject[];
};

const Header = () => (
  <Box
    position="sticky"
    top={0}
    h="150px"
    w="100%"
    pt={6}
    pl={6}
    bgGradient="linear(to-b, #0f171f 0%, rgba(0, 0, 0, 0) 100%)"
  >
    <Kbd bgColor="black">Text Adventure</Kbd>
  </Box>
);

const UserInput = ({
  value,
  setValue,
  onClick,
}: {
  value: string;
  setValue: (value: string) => void;
  onClick: () => void;
}) => (
  <InputGroup w="900px" position="fixed" margin={8} bottom={0}>
    <Input
      value={value}
      onChange={(event) => setValue(event?.target?.value.toLowerCase())}
      placeholder="Tap your command"
      variant="filled"
      height={20}
      bg="#2d3238"
      color={"#909497"}
      _hover={{
        background: "#0f171f ",
      }}
      focusBorderColor="teal.500"
      _focus={{
        bg: "#2d3238",
      }}
    />
    <InputRightElement height={20} mr={8}>
      <Button size="sm" px={8} onClick={onClick} type="submit">
        Send
      </Button>
    </InputRightElement>
  </InputGroup>
);

const Home = () => {
  const [userCommand, setUserCommand] = useState("");
  const [inventory, setInventory] = useState<SceneObject[]>([]);
  const [currentScene, setCurrentScene] = useState<Scene>(
    gameFile?.scenes[0] as unknown as Scene
  );
  const [descriptionToRender, setDescriptionToRender] = useState<string[]>([
    gameFile?.scenes[0].description,
  ]);
  const scrollRef = useRef<null | HTMLDivElement>(null);

  const print = (text: string) => {
    setDescriptionToRender((currentDescription) =>
      currentDescription.concat(text)
    );
  };

  const getSceneObjectByName = (searchObjectName: string) => {
    return currentScene?.objects?.find(
      (obj) => obj.objectName === searchObjectName
    );
  };
  const getInventoryObjectByName = (searchObjectName: string) => {
    return inventory?.find((obj) => obj.objectName === searchObjectName);
  };

  const handleObjDescriptionCommand = () => {
    const objName = userCommand.trim().split(" ")[1];
    const object = getSceneObjectByName(objName);
    if (object) {
      setDescriptionToRender((currentDescription) =>
        currentDescription.concat(object.objectDescription)
      );
    } else {
      setDescriptionToRender((currentDescription) =>
        currentDescription.concat("OBJECT NOT FOUND")
      );
    }
  };

  const handleGetObjectCommand = () => {
    const objName = userCommand.trim().split(" ")[1];

    const object = getSceneObjectByName(objName);
    if (object) {
      const isObjectAlreadyOnInventory = inventory.find(
        (item) => item.objectName === object.objectName
      );

      if (!object.possibleToCarry)
        return print(object?.negativeResult || "UNABLE TO GET THIS ITEM");

      if (isObjectAlreadyOnInventory) return print("ITEM ALREADY ON INVENTORY");

      setInventory([object, ...inventory]);
      print(`${object.objectName.toUpperCase()} ADDED TO THE INVENTORY`);
    } else {
      print("OBJECT NOT FOUND");
    }
  };

  const handleShowInventoryCommand = () => {
    const inventoryItemsNames = inventory
      ?.map((item) => item.objectName)
      .join(", ");
    print(
      inventoryItemsNames.length
        ? `INVENTORY: ${inventoryItemsNames}`
        : "EMPTY INVENTORY"
    );
  };

  const handleSimpleUseCommand = (commandSplited: string[]) => {
    const object = getSceneObjectByName(commandSplited[1]);
    if (
      object &&
      !object.possibleToCarry &&
      object.correctCommand === userCommand
    ) {
      print(object.positiveResult);
      setCurrentScene(gameFile.scenes[object.targetScene] as unknown as Scene);
      print(gameFile.scenes[object.targetScene].description);
      return;
    }
    return print(object?.negativeResult || "OBJECT NOT FOUND");
  };

  const handleUseWithCommand = (commandSplited: string[]) => {
    if (commandSplited[2] !== "with") return print("INVALID COMMAND");
    const sceneObject = getSceneObjectByName(commandSplited[3]);
    const inventoryObject = getInventoryObjectByName(commandSplited[1]);

    if (sceneObject && !sceneObject.possibleToCarry && inventoryObject) {
      if (sceneObject.correctCommand === userCommand) {
        print(sceneObject.positiveResult);
        setCurrentScene(
          gameFile.scenes[sceneObject.targetScene] as unknown as Scene
        );
        print(gameFile.scenes[sceneObject.targetScene].description);
        return;
      }
      return print(sceneObject?.negativeResult || "OBJECT NOT FOUND");
    }
    return print(sceneObject?.negativeResult || "INVALID COMMAND");
  };

  const handleUseCommand = () => {
    const commandSplited = userCommand.trim().split(" ");
    if (commandSplited.length === 2) {
      return handleSimpleUseCommand(commandSplited);
    }
    if (commandSplited.length === 4) {
      return handleUseWithCommand(commandSplited);
    }
    print("INVALID COMMAND");
    // const isCorrectCommand = currentScene.objects?.some(
    //   (object) => object.correctCommand === userCommand
    // );
  };

  const handleSaveCommand = () => {
    localStorage.setItem("currentScene", JSON.stringify(currentScene));
    localStorage.setItem("inventory", JSON.stringify(inventory));
    print("SAVING...");
  };

  const handleLoadGameCommand = () => {
    const scene = localStorage.getItem("currentScene");
    const invent = localStorage.getItem("inventory");
    if (!scene && invent) {
      return print("SAVE NOT FOUND");
    }
    if (scene) {
      setCurrentScene(JSON.parse(scene));
      setDescriptionToRender(["SAVE LOADED"]);
      print(JSON.parse(scene).description);
    }
    if (invent) {
      setInventory(JSON.parse(invent));
    }
  };

  const handleRestartCommand = () => {
    setCurrentScene(gameFile.scenes[0] as unknown as Scene);
    setInventory([]);
    setDescriptionToRender([gameFile.scenes[0].description]);
  };

  const checkCommand = () => {
    print(`$${userCommand}`);
    const firstCommand = userCommand.split(" ")[0];
    switch (firstCommand) {
      case "use":
        handleUseCommand();
        break;
      case "get":
        handleGetObjectCommand();
        break;
      case "help":
        print(gameFile.help);
        break;
      case "check":
        handleObjDescriptionCommand();
        break;
      case "inventory":
        handleShowInventoryCommand();
        break;
      case "save":
        handleSaveCommand();
        break;
      case "load":
        handleLoadGameCommand();
        break;
      case "restart":
        handleRestartCommand();
        break;
      default:
        print("INVALID COMMAND");
    }
    scrollRef?.current?.scrollIntoView({
      behavior: "smooth",
    });
    setUserCommand("");
  };

  return (
    <>
      <Box
        pb={12}
        minH="100vh"
        maxH="100%"
        w="100%"
        bgGradient="linear(to-b, #0f171f, #343d47)"
        flexDirection="column"
        display="flex"
        alignItems="center"
      >
        <Header />
        <Flex direction="column" gap={4} marginBottom={160}>
          {descriptionToRender.map((desc, index) => (
            <TextDisplay text={desc} key={index} />
          ))}
        </Flex>

        <UserInput
          value={userCommand}
          setValue={setUserCommand}
          onClick={checkCommand}
        />
      </Box>
      <div ref={scrollRef} />
    </>
  );
};

export default Home;
