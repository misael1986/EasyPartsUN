import React, { useState } from "react";
import "./compare-parts.css";
import { inject, observer } from "mobx-react";

import { FaRegWindowMinimize } from "react-icons/fa";
import { FiMaximize2 } from "react-icons/fi";

function CompareParts({ compareStore }) {
  const [show, setShow] = useState(false);

  const hiddenProps = ["linkinfo", "type", "imagen", "link", "id", "nombre"];

  const renderKeys = () => (
    <div className="Keys">
      {compareStore.parts[0] !== undefined &&
        Object.keys(compareStore.parts[0]).map((key) => {
          return !hiddenProps.includes(key) ? (
            <p className="Key">{key}</p>
          ) : null;
        })}
    </div>
  );

  const renderPart = (part) => (
    <div className="Part">
      <img className="PartImage" src={part.imagen} alt="Imagen del objeto" />
      {Object.keys(part).map((prop) => {
        return !hiddenProps.includes(prop) ? (
          <p className="Prop">{part[prop]}</p>
        ) : null;
      })}
    </div>
  );

  return (
    <>
      {compareStore.parts.length > 0 ? (
        <div
          className="CompareParts"
          style={show ? {} : { backgroundColor: "transparent" }}
        >
          {show ? (
            <>
              {renderKeys()}
              {compareStore.parts.map((part) => renderPart(part))}
            </>
          ) : null}
          {show ? (
            <FaRegWindowMinimize
              className="Hide"
              onClick={() => setShow(false)}
            />
          ) : (
            <div
              className="Show"
              onClick={() => {
                if (compareStore.parts.length > 0) {
                  setShow(true);
                }
              }}
            >
              <FiMaximize2 className="ShowImage" />
              <p className="ShowText">Ver comparativa</p>
            </div>
          )}
        </div>
      ) : null}
    </>
  );
}

export default inject("compareStore")(observer(CompareParts));
