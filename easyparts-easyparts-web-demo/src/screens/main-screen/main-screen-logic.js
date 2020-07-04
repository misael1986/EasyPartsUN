import api from "../../axios/api";
import { CompareStore, SearchStore, UserStore } from "../../stores";
import { DESCRIPTIONS } from "../../utils/string";
import {
  getListDependingOnType,
  getRequestMappingForType,
} from "../../utils/api";

function mapFilters(filters) {
  let mapped = [];
  let i = 0;
  for (const prop in filters) {
    mapped.push({
      id: ++i,
      name: prop,
      databaseName: prop,
      values: filters[prop],
      selected: null,
    });
  }
  return mapped;
}

function getListFromService(type) {
  SearchStore.typeSelected = type;
  SearchStore.componentDescription = DESCRIPTIONS[type];
  SearchStore.searchText = "";
  api[type]
    .getAll("all")
    .then((success) => {
      // first we obtain the filters
      let filters = mapFilters(success.data.filtros);
      SearchStore[type + "Filters"] = [...filters];
      api[type]
        .getAll(getRequestMappingForType(type))
        .then((success) => {
          // then we obtain the list
          let list = getListDependingOnType(type, success.data);
          list.forEach((item) => (item.type = type));
          SearchStore.searchList = list;
          SearchStore[type + "List"] = [...list];
        })
        .catch((error) => console.log(error));
    })
    .catch((error) => console.log(error));
}

function choosePart(item) {
  CompareStore.parts = [];

  UserStore.pc[item.type] = item;
  switch (item.type) {
    case "cpu":
      getListFromService("motherboard");
      break;
    case "motherboard":
      getListFromService("gpu");
      break;
    case "gpu":
      getListFromService("ram");
      break;
    case "ram":
      getListFromService("storage1");
      break;
    case "storage1":
      getListFromService("storage2");
      break;
    case "storage2":
      getListFromService("chassis");
      break;
    case "chassis":
      getListFromService("powerSource");
      break;
    case "powerSource":
    default:
      break;
  }

  UserStore.quantities = {
    ...UserStore.quantities,
    [item.type]: 1,
  };
}

function selectFilter(filter, selected) {
  if (filter.selected === null || filter.selected !== selected) {
    filter.selected = selected;
  } else {
    filter.selected = null;
  }
}

function resetFilters(filters) {
  filters.forEach((filter) => (filter.selected = null));
}

function returnToPart(type) {
  CompareStore.parts = [];

  getListFromService(type);

  // This can be optimized with a recursive function
  switch (type) {
    case "powerSource":
      UserStore.pc = { ...UserStore.pc, powerSource: null };
      break;
    case "chassis":
      UserStore.pc = { ...UserStore.pc, powerSource: null, chassis: null };
      break;
    case "storage2":
      UserStore.pc = {
        ...UserStore.pc,
        powerSource: null,
        chassis: null,
        storage2: null,
      };
      break;
    case "storage1":
      UserStore.pc = {
        ...UserStore.pc,
        powerSource: null,
        chassis: null,
        storage2: null,
        storage1: null,
      };
      break;
    case "ram":
      UserStore.pc = {
        ...UserStore.pc,
        powerSource: null,
        chassis: null,
        storage2: null,
        storage1: null,
        ram: null,
      };
      break;
    case "gpu":
      UserStore.pc = {
        ...UserStore.pc,
        powerSource: null,
        chassis: null,
        storage2: null,
        storage1: null,
        ram: null,
        gpu: null,
      };
      break;
    case "motherboard":
      UserStore.pc = {
        ...UserStore.pc,
        powerSource: null,
        chassis: null,
        storage2: null,
        storage1: null,
        ram: null,
        gpu: null,
        motherboard: null,
      };
      break;
    case "cpu":
      UserStore.pc = {
        powerSource: null,
        chassis: null,
        storage2: null,
        storage1: null,
        ram: null,
        gpu: null,
        motherboard: null,
        cpu: null,
      };
      break;
    default:
      break;
  }

  switch (type) {
    case "storage2":
      UserStore.quantities = {
        ...UserStore.quantities,
        storage2: 0,
      };
      break;
    case "storage1":
      UserStore.quantities = {
        ...UserStore.quantities,
        storage2: 0,
        storage1: 0,
      };
      break;
    case "powerSource":
    case "chassis":
      break;
    default:
      UserStore.quantities = {
        ram: 0,
        storage1: 0,
        storage2: 0,
      };
      break;
  }
}

function addToCompare(part) {
  if (CompareStore.parts.includes(part)) {
    CompareStore.parts.splice(CompareStore.parts.indexOf(part), 1);
  } else if (CompareStore.parts.length < 3) {
    CompareStore.parts.push(part);
  }
}

function goToFinalScreen(history) {
  history.push("/");
  history.push("/final");
}

export {
  getListFromService,
  choosePart,
  selectFilter,
  resetFilters,
  returnToPart,
  addToCompare,
  goToFinalScreen,
};
