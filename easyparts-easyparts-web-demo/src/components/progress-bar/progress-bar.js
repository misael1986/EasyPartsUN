import React from "react";
import "./progress-bar.css";
import { ProgressBarPart } from "../index";

function ProgressBar({ pc, returnToPart }) {
  return (
    <div className="ProgressBar">
      <ProgressBarPart
        type="cpu"
        part={pc.cpu}
        name="Procesador"
        returnToPart={returnToPart}
      />
      <ProgressBarPart
        type="motherboard"
        part={pc.motherboard}
        name="Tarjeta Madre"
        returnToPart={returnToPart}
      />
      <ProgressBarPart
        type="gpu"
        part={pc.gpu}
        name="Tarjeta Gráfica"
        returnToPart={returnToPart}
      />
      <ProgressBarPart
        type="ram"
        part={pc.ram}
        name="RAM"
        returnToPart={returnToPart}
      />
      <ProgressBarPart
        type="storage1"
        part={pc.storage1}
        name="Almacenamiento"
        returnToPart={returnToPart}
      />
      <ProgressBarPart
        type="storage2"
        part={pc.storage2}
        name="Almacenamiento"
        returnToPart={returnToPart}
      />
      <ProgressBarPart
        type="chassis"
        part={pc.chassis}
        name="Gabinete"
        returnToPart={returnToPart}
      />
      <ProgressBarPart
        type="powerSource"
        part={pc.powerSource}
        name="Fuente de Poder"
        returnToPart={returnToPart}
      />
    </div>
  );
}

export default ProgressBar;
