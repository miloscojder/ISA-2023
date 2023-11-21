import { Timestamp } from "rxjs";

interface UserInterface{
    id:number;
    username: string ;
    password: string ;
    email: string;
    firstName: string;
    lastName: string;
    mobile:string;
    city:string;
    state:string;
    sex:string;
    profession:string;
    organizationInformation:string;
    enabled:boolean;
    //lastPasswordResetDate:string;
    role:string;
    authorities: [] ;
    
    
}
export class User implements UserInterface{
    id:number;
    username: string ;
    password: string ;
    email: string;
    firstName: string;
    lastName: string;
    mobile:string;
    city:string;
    state:string;
    sex:string;
    profession:string;
    organizationInformation:string;
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
        this.city=obj.city;
        this.state=obj.state;
        this.sex=obj.sex;
        this.profession=obj.profession
        this.organizationInformation=obj.organizationInformation;
        this.enabled = obj.enabled;
        //this.lastPasswordResetDate = obj.lastPasswordResetDate;
        this.role = obj.role;
        this.authorities=obj.authorities;
    } 
}