import React from "react";
import "./app.css";
import {
  FinalScreen,
  ForgotScreen,
  LandingScreen,
  LoginScreen,
  MainScreen,
  NewPasswordScreen,
  PurposeListScreen,
  SignUpScreen,
  VerifyScreen,
} from "../../screens";

import { Provider } from "mobx-react";
import {
  CompareStore,
  PurposeStore,
  SearchStore,
  UserStore,
} from "../../stores";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

export default () => {
  const stores = {
    searchStore: SearchStore,
    userStore: UserStore,
    compareStore: CompareStore,
    purposeStore: PurposeStore,
  };

  return (
    <Provider {...stores}>
      <div className="dark-theme">
        <Router>
          <Switch>
            <Route path="/" exact component={LandingScreen} />
            <Route path="/estiloEP" exact component={MainScreen} />
            <Route path="/final" exact component={FinalScreen} />
            <Route path="/purposeList" exact component={PurposeListScreen} />
            <Route path="/login" exact component={LoginScreen} />
            <Route path="/signup" exact component={SignUpScreen} />
            <Route path="/forgot" exact component={ForgotScreen} />
            <Route path="/newPassword" exact component={NewPasswordScreen} />
            <Route path="/verify" exact component={VerifyScreen} />
          </Switch>
        </Router>
      </div>
    </Provider>
  );
};
