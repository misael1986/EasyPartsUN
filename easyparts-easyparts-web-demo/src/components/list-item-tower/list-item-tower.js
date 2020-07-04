import React from "react";
import "./list-item-tower.css";

import { formatMoney } from "../../utils/string";

function ListItemTower({ tower, onClick }) {
  const renderPart = (key, definition, part, customDesc) => (
    <div key={key} className="PartRow">
      <img className="PartRowImg" src={part.imagen} alt="Img" />
      <p className="PartLabel">
        {definition}: {customDesc !== undefined ? customDesc + " " : null}
        {part.marca + " " + part.nombre}
      </p>
    </div>
  );
  return (
    <div className="ListItemTower" onClick={onClick}>
      <img className="TowerImg" src={tower.gabinete.imagen} alt="Img" />
      <div className="PartList">
        {renderPart(0, "Procesador", tower.procesador)}
        {renderPart(
          1,
          "Ram",
          tower.ram,
          tower.cant_ram + " x " + tower.ram.capacidad
        )}
        {renderPart(2, "Tarjeta de Video", tower.tarjetaVideo)}
        {tower.discos.map((disk, key) => renderPart(key, "Disco", disk))}
      </div>
      <p className="Cost">{formatMoney(tower.preciototal, 0)}</p>
    </div>
  );
}

export default ListItemTower;
