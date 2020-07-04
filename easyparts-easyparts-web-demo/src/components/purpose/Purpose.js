import React, { Component } from "react";
import "./Purpose.css";
import Navbar from "../nav-bar/nav-bar";
import { Parallax } from "react-parallax";
import SpecificPurpose from "../specific-purpose/SpecificPurpose";

const inlineStyle = {
  left: "50%",
  top: "50%",
  position: "absolute",
  padding: "20px",
  transform: "translate(-50%, -50%)",
  color: "#fff",
};

class Purpose extends Component {
  render() {
    return (
      <div id="proposito">
        <div className="izqPurpose">
          <Parallax
            bgImage={require("../../assets/Parallax2.jpg")}
            strength={500}
          >
            <Navbar />
            <div style={{ height: "100vh" }}>
              <div style={inlineStyle}>
                <h1 style={{ fontSize: "40px" }}>Propósito</h1>
              </div>
            </div>
          </Parallax>
        </div>

        <div className="derPurpose">
          <div className="containerDescription">
            <h2>Escoge el propósito...</h2>
            <p>
              Puedes ver recomendaciones de computadores ya armados con el
              propósito deseado
            </p>
          </div>
          <div className="containerPurpose">
            <SpecificPurpose nombre="Gamer" />
            <SpecificPurpose nombre="Diseño" />
            <SpecificPurpose nombre="Minería" />
          </div>
          <div className="containerPurpose">
            <SpecificPurpose nombre="Oficina" />
            <SpecificPurpose nombre="Servidor" />
          </div>
        </div>
      </div>
    );
  }
}

export default Purpose;
