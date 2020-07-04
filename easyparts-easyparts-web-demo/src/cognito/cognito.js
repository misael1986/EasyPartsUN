import {
  AuthenticationDetails,
  CognitoUser,
  CognitoUserPool,
} from "amazon-cognito-identity-js";
import { UserStore } from "../stores";

const poolData = {
  UserPoolId: process.env.REACT_APP_USER_POOL_ID,
  ClientId: process.env.REACT_APP_CLIENT_ID,
};

class Cognito {
  constructor() {
    this.userPool = new CognitoUserPool(poolData);
  }

  get user() {
    return new CognitoUser({
      Username: UserStore.email,
      Pool: this.userPool,
    });
  }

  get authDetails() {
    return new AuthenticationDetails({
      Username: UserStore.email,
      Password: UserStore.password,
    });
  }
}

export default new Cognito();
