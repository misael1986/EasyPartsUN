import React, { useState } from "react";
import "./progress-bar-part.css";

function ProgressBarPart({ type, part, name, returnToPart }) {
  const [showBack, setShowBack] = useState(false);

  const renderSelected = () => (
    <div className="PartSelected" onPointerEnter={() => setShowBack(true)}>
      <p className="PartSelectedTitle">{name}</p>
      <img
        className="PartSelectedImage"
        src={part.imagen}
        alt="Imagen del Producto"
      />
      <p className="PartSelectedDesc">{part.nombre}</p>
    </div>
  );

  return (
    <div
      className="ProgressBarPart"
      onPointerLeave={() => setShowBack(false)}
      onClick={() => {
        if (showBack) {
          returnToPart(type);
        }
      }}
    >
      {part === null ? (
        <p className="PartNull">{name}</p>
      ) : showBack ? (
        <div className="Part-tooltip">
          <p className="PartSelectedDesc">Volver a</p>
          <p className="PartSelectedDesc">{name}</p>
        </div>
      ) : (
        renderSelected()
      )}
    </div>
  );
}

export default ProgressBarPart;
