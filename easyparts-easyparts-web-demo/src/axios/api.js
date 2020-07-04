import axios from "axios";

const API = axios.create({
  baseURL: process.env.REACT_APP_SERVER_BASE_URL,
});

const cpu = {
  getAll: (params) => API.get("/procesador/" + params),
};

const gpu = {
  getAll: (params) => API.get("/tarjetavideo/" + params),
};

const ram = {
  getAll: (params) => API.get("/ram/" + params),
};

const motherboard = {
  getAll: (params) => API.get("/motherboard/" + params),
};

const chassis = {
  getAll: (params) => API.get("/gabinete/" + params),
};

const powerSource = {
  getAll: (params) => API.get("/powerSource/" + params),
};

const storage1 = {
  getAll: (params) => API.get("/almacenamiento/" + params),
};
const storage2 = {
  getAll: (params) => API.get("/almacenamiento/" + params),
};

const tower = {
  getAll: (params) => API.get("/torre/" + params),
  find: (id) => API.get("/torre/find/" + id),
  purpose: (purpose) => API.get("/torre/proposito/" + purpose),
};

export default {
  cpu,
  gpu,
  ram,
  motherboard,
  chassis,
  powerSource,
  storage1,
  storage2,
  tower,
};
