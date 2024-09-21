import * as React from "react";

import { ChakraProvider, extendTheme } from "@chakra-ui/react";
import Home from "./pages/Home";

const theme = extendTheme({
  styles: {
    global: {
      body: {
        color: "white",
      },
    },
  },
});

export default function App() {
  return (
    <ChakraProvider theme={theme}>
      <Home />
    </ChakraProvider>
  );
}
