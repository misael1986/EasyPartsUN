import React, { useState } from "react";
import "./pc-part.css";

import imageP from "../../assets/procesador.png";
import imageR from "../../assets/ram.png";
import imageA from "../../assets/almacenamiento.png";
import imageT from "../../assets/tarjetavideo.png";
import imageM from "../../assets/pcPartExampleImage.png";
import imagePS from "../../assets/powersource.png";
import imageG from "../../assets/gabinete.png";

import { AiOutlineCheckSquare } from "react-icons/ai";
import { FaRegSquare } from "react-icons/fa";
import { CompareStore } from "../../stores";

function PcPart({ item, choosePart, addToCompare }) {
  const getSpecifics = () => {
    switch (item.type) {
      case "cpu":
        return {
          image: imageP,
          description:
            "Numero de nucleos: " +
            item.num_nucleos +
            ". Frecuencia: " +
            item.frecuencia +
            "GHz. Cache: " +
            item.pcache +
            "MB. Tarjeta grafica integrada: " +
            item.grafica_integrada +
            ". Sockect: " +
            item.psocket +
            ". Potencia maxima: " +
            item.potencia_max,
        };
      case "ram":
        return {
          image: imageR,
          description:
            "Capacidad: " +
            item.capacidad +
            ". Velocidad: " +
            item.velocidad +
            ". Tecnologia: " +
            item.tecnologia +
            ". Potencia maxima: " +
            item.potencia_max,
        };
      case "storage1":
      case "storage2":
        return {
          image: imageA,
          description:
            "Capacidad: " +
            item.capacidad +
            ". Tecnologia: " +
            item.tecnologia +
            ". Puerto: " +
            item.puerto +
            ". Velocidad de lectura: " +
            item.velocidad_lectura +
            ". Velocidad de escritura: " +
            item.velocidad_escritura +
            ". Potencia maxima: " +
            item.potencia_max,
        };
      case "gpu":
        return {
          image: imageT,
          description:
            "Pci express: " +
            item.pci_express +
            ". Tipo de memoria: " +
            item.tipo_memoria +
            ". Capacidad: " +
            item.capacidad_memoria +
            ". Proposito: " +
            item.proposito +
            ". Potencia maxima: " +
            item.potencia_max,
        };
      case "motherboard":
        return {
          image: imageM,
          description:
            "Categoria: " +
            item.categoria +
            ". Socket: " +
            item.msocket +
            ". Bios: " +
            item.bios +
            ". Slot para RAM: " +
            item.slot_ram +
            " (x" +
            item.ram_cantidad +
            "). Slot para video: " +
            item.slot_gpu +
            " (x" +
            item.gpu_cantidad +
            "). SATA: " +
            item.tipo_sata +
            " (x" +
            item.cantidad_sata +
            "). MDOS: " +
            item.mdos_cantidad,
        };
      case "powerSource":
        return {
          image: imagePS,
          description:
            "Potencia: " +
            item.potencia +
            ". Certificacion: " +
            item.certificacion,
        };
      case "chassis":
        return {
          image: imageG,
          description:
            "Motherboards: " +
            item.motherboards +
            ". Dimensiones: " +
            item.alto +
            "x" +
            item.largo +
            "x" +
            item.ancho +
            "(alto X largo X ancho).",
        };
      default:
        return null;
    }
  };

  const [masInfo, setMasInfo] = useState(false);
  const [comparing, setComparing] = useState(false);

  return (
    <div
      className="PcPartLink"
      onClick={choosePart}
      onPointerEnter={() => setMasInfo(true)}
      onPointerLeave={() => setMasInfo(false)}
    >
      <div className="PcPart">
        <img className="Image" src={item.imagen} alt="Imagen del objeto" />
        <p className="descripcion">{item.nombre}</p>
        <p className="descripcion">Precio: ${item.precio}</p>
        <div className={masInfo ? "tooltip-visible" : "tooltip-hidden"}>
          <p className="descripcion">{getSpecifics().description}</p>
          <p className="linkinfo">
            <a href={item.linkinfo} target="_blank" rel="noopener noreferrer">
              Mas información
            </a>
          </p>
          <div className="Compare">
            <p className="CompareText">Agregar a comparar</p>
            {comparing ? (
              <AiOutlineCheckSquare
                className="CompareBox"
                onClick={(event) => {
                  setComparing(false);
                  event.stopPropagation();
                  addToCompare(item);
                }}
              />
            ) : (
              <FaRegSquare
                className="CompareBox"
                onClick={(event) => {
                  if (CompareStore.parts.length < 3) {
                    setComparing(true);
                    addToCompare(item);
                  }
                  event.stopPropagation();
                }}
              />
            )}
          </div>
        </div>
      </div>
    </div>
  );
}

export default PcPart;
