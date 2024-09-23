import { Box } from "@chakra-ui/react";
import { useEffect, useState } from "react";

const TextDisplay = ({ text }: { text: string }) => {
  const [typedText, setTypedText] = useState("");

  const typingRender = (
    text: string,
    updater: (localTyping: string) => void,
    interval: number
  ) => {
    let localTypingIndex = 0;
    let localTyping = "";
    if (text) {
      let printer = setInterval(() => {
        if (localTypingIndex < text.length) {
          updater((localTyping += text[localTypingIndex]));
          localTypingIndex += 1;
        } else {
          localTypingIndex = 0;
          localTyping = "";
          clearInterval(printer);
        }
      }, interval);
    }
  };

  useEffect(() => {
    typingRender(text, setTypedText, 2);
  }, [text]);

  return (
    <pre
      style={{
        maxWidth: "900px",
        wordBreak: "break-word",
        whiteSpace: "pre-line",
        maxHeight: "90vh",
        fontSize: "18px",
      }}
    >
      {typedText}
    </pre>
  );
};

export default TextDisplay;
