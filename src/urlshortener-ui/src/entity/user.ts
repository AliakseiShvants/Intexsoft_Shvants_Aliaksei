export class User{

  userId: number;
  fullName: string;
  login: string;
  password: string;
  confirmPassword: string;

  constructor( fullName: string, login: string, password: string, confirmPassword: string) {
    this.fullName = fullName;
    this.login = login;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }
}
