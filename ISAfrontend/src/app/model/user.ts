import { Timestamp } from "rxjs";

interface UserInterface{
    id:number;
    username: string ;
    password: string ;
    email: string;
    firstName: string;
    lastName: string;
    mobile:string;
    enabled:boolean;
    //lastPasswordResetDate:string;
    role:string;
    authorities: [] ;
    
}
export class User implements UserInterface{
    id:number;
    firstName: string;
    lastName: string;
    email: string;
    username: string ;
    password: string ;
    mobile:string;
    enabled:boolean;
    //lastPasswordResetDate:string;
    role:string;
    authorities: [] ;
    constructor(obj:UserInterface){
        this.id=obj.id;
        this.firstName=obj.firstName;
        this.lastName=obj.lastName;
        this.email=obj.email;
        this.username=obj.username;
        this.password=obj.password;
        this.mobile = obj.mobile;
        this.enabled = obj.enabled;
        //this.lastPasswordResetDate = obj.lastPasswordResetDate;
        this.role = obj.role;
        this.authorities=obj.authorities;
    } 
}