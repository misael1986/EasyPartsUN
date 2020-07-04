import React from "react";
import "./progress-bar-quantities.css";

function ProgressBarQuantities({
  quantities,
  setRamQuantity,
  setStorageQuantity,
}) {
  const ramClassNames = "Quantity" + (quantities.ram === 0 ? " Hidden" : "");
  const storage1ClassNames =
    "Quantity" + (quantities.storage1 === 0 ? " Hidden" : "");
  const storage2ClassNames =
    "Quantity" + (quantities.storage2 === 0 ? " Hidden" : "");

  return (
    <div className="ProgressBarQuantities">
      <div className="Empty" />
      <div className="Empty" />
      <div className="Empty" />
      <div className={ramClassNames}>
        <p className="Button" onClick={() => setRamQuantity(false)}>
          -
        </p>
        <p className="Value">{quantities.ram}</p>
        <p className="Button" onClick={() => setRamQuantity(true)}>
          +
        </p>
      </div>
      <div className={storage1ClassNames}>
        <p className="Button" onClick={() => setStorageQuantity("1", false)}>
          -
        </p>
        <p className="Value">{quantities.storage1}</p>
        <p className="Button" onClick={() => setStorageQuantity("1", true)}>
          +
        </p>
      </div>
      <div className={storage2ClassNames}>
        <p className="Button" onClick={() => setStorageQuantity("2", false)}>
          -
        </p>
        <p className="Value">{quantities.storage2}</p>
        <p className="Button" onClick={() => setStorageQuantity("2", true)}>
          +
        </p>
      </div>
      <div className="Empty" />
      <div className="Empty" />
    </div>
  );
}

export default ProgressBarQuantities;
