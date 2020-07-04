import React from "react";
import "./landing-screen.css";
import { inject, observer } from "mobx-react";
import { Parallax } from "react-parallax";
import Navbar from "../../components/nav-bar/nav-bar";
import Purpose from "../../components/purpose/Purpose";
import EstiloEasyParts from "../../components/estilo-easy-parts/EstiloEasyParts";

const inlineStyle = {
  left: "50%",
  top: "50%",
  position: "absolute",
  padding: "20px",
  transform: "translate(-50%, -50%)",
  color: "#fff",
};

function LandingScreen({ userStore }) {
  return (
    <div className="principal">
      <div id="inicio" style={{ height: "100vh" }}>
        <Parallax
          bgImage={require("../../assets/Parallax1.jpg")}
          strength={500}
        >
          <Navbar />
          <div style={{ height: "100vh" }}>
            <div style={inlineStyle}>
              <h1 style={{ fontSize: "100px" }}>EasyParts</h1>
            </div>
          </div>
        </Parallax>
      </div>

      <br />
      <br />

      <Purpose />

      <br />
      <br />

      <EstiloEasyParts />
    </div>
  );
}

export default inject("userStore")(observer(LandingScreen));
