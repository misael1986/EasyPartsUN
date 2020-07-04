import { decorate, observable } from "mobx";

class Search {
  constructor() {
    this.cpuList = [];
    this.motherboardList = [];
    this.gpuList = [];
    this.ramList = [];
    this.storage1List = [];
    this.storage2List = [];
    this.chassisList = [];
    this.powerSourceList = [];

    this.typeSelected = "cpu";

    this.searchList = [];
    this.searchText = "";
    this.componentDescription = "Procesador";

    this.cpuFilters = [];
    this.motherboardFilters = [];
    this.gpuFilters = [];
    this.ramFilters = [];
    this.storage1Filters = [];
    this.storage2Filters = [];
    this.chassisFilters = [];
    this.powerSourceFilters = [];
  }

  clear() {
    this.cpuList = [];
    this.motherboardList = [];
    this.gpuList = [];
    this.ramList = [];
    this.storage1List = [];
    this.storage2List = [];
    this.chassisList = [];
    this.powerSourceList = [];

    this.typeSelected = "cpu";

    this.searchList = [];
    this.searchText = "";
    this.componentDescription = "Procesador";

    this.cpuFilters = [];
    this.motherboardFilters = [];
    this.gpuFilters = [];
    this.ramFilters = [];
    this.storage1Filters = [];
    this.storage2Filters = [];
    this.chassisFilters = [];
    this.powerSourceFilters = [];
  }

  get filterFromType() {
    return this[this.typeSelected + "Filters"];
  }

  get searchListFiltered() {
    let byName = this.searchList.filter((it) => {
      return it.nombre.includes(this.searchText);
    });
    const filtersForType = this.filterFromType;
    for (let i = 0; i < filtersForType.length; i++) {
      byName = byName.filter((it) => {
        return !(
          filtersForType[i].selected !== null &&
          it[filtersForType[i].databaseName] !== filtersForType[i].selected
        );
      });
    }
    return byName;
  }
}

decorate(Search, {
  searchList: observable,
  searchText: observable,

  componentDescription: observable,

  cpuFilters: observable,
  motherboardFilters: observable,
  gpuFilters: observable,
  ramFilters: observable,
  storage1Filters: observable,
  storage2Filters: observable,
  chassisFilters: observable,
  powerSourceFilters: observable,
});

export default new Search();
