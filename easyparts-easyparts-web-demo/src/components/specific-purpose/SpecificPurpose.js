import React, { useState } from "react";
import "./SpecificPurpose.css";

import imageGamer from "../../assets/gamer.jpg";
import imageDiseño from "../../assets/diseño.jpg";
import imageMineria from "../../assets/mineria.jpg";
import imageOficina from "../../assets/oficina.jpg";
import imageServidor from "../../assets/servidor.jpg";
import { useHistory } from "react-router-dom";
import { PurposeStore, SearchStore, UserStore } from "../../stores";

function SpecificPurpose({ nombre }) {
  const history = useHistory();

  const pickPurpose = (purpose) => {
    if (UserStore.pc.powerSource !== null) {
      UserStore.pc2 = { ...UserStore.pc };
      UserStore.quantities2 = { ...UserStore.quantities };
      SearchStore.typeSelected = "cpu";
    }

    PurposeStore.name = purpose;
    history.push("/purposeList");
  };

  const getImage = () => {
    switch (nombre) {
      case `Gamer`:
        return imageGamer;
      case `Diseño`:
        return imageDiseño;
      case `Minería`:
        return imageMineria;
      case `Oficina`:
        return imageOficina;
      case `Servidor`:
        return imageServidor;
      default:
        return null;
    }
  };

  const getRoute = () => {
    switch (nombre) {
      case `Gamer`:
        return "gamer";
      case `Diseño`:
        return "diseño";
      case `Minería`:
        return "mineria";
      case `Oficina`:
        return "oficina";
      case `Servidor`:
        return "servidor";
      default:
        return null;
    }
  };

  const getDescription = () => {
    switch (nombre) {
      case `Gamer`:
        return "Si lo tuyo es los juegos aquí puedes ver las mejores recomendaciones aquí";
      case `Diseño`:
        return "¿Te gusta diseñar? Aquí encontrarás el mejor computador para ti";
      case `Minería`:
        return "Encontrar patrones, tendencias o reglas que expliquen el comportamiento de grandes volumenes de datos...";
      case `Oficina`:
        return "Uso casual, hogar u oficina... Equipos con lo suficiente para lo que necesitas";
      case `Servidor`:
        return "Si necesitas un computador dedicado a funciones de Servidor, aquí puedes encontrar algunos";
      default:
        return null;
    }
  };

  const sectionStyle = {
    backgroundImage: "url(" + getImage() + ")",
    backgroundSize: "cover",
    backgroundRepeat: "no-repeat",
  };

  const [masInfo, setMasInfo] = useState(false);

  return (
    <div
      className="specific"
      style={sectionStyle}
      onPointerEnter={() => setMasInfo(true)}
      onPointerLeave={() => setMasInfo(false)}
    >
      <div
        className={masInfo ? "tooltip-visibleP" : "tooltip-hiddenP"}
        onClick={() => pickPurpose(getRoute())}
      >
        <br />
        <p style={{ fontWeight: "bold" }}>{nombre}</p>
        <br />
        <p className="textDescription">{getDescription()}</p>
      </div>

      <div className={masInfo ? "noTrans" : "trans"}>
        <div className="text">{nombre}</div>
      </div>
    </div>
  );
}

export default SpecificPurpose;
