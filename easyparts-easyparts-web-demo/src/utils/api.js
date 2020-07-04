import { UserStore } from "../stores";

export function getListDependingOnType(type, data) {
  if (type === "cpu") {
    return data.procesadores;
  } else if (type === "storage1" || type === "storage2") {
    return data.almacenamientos;
  } else {
    return data;
  }
}

export function getRequestMappingForType(type) {
  switch (type) {
    case "motherboard":
      return "socket/" + UserStore.pc.cpu.psocket;
    case "gpu":
      return "puerto/" + UserStore.pc.motherboard.slot_gpu;
    case "ram":
      return "tecnologia/" + UserStore.pc.motherboard.slot_ram;
    case "storage":
      return "all";
    case "chassis":
      return "board/" + UserStore.pc.motherboard.categoria;
    case "powerSource":
      return "potencia/" + UserStore.pcPower;
    default:
      return "all";
  }
}
