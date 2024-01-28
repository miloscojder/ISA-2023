interface RegisteredUserInterface{
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string; 
    email: string;
    mobile:string;
    city:string;
    state:string;
    sex:string;
    profession:string;
    organizationInformation:string;
    enabled:boolean;
    points: number;
    category: string;
    benefits: string;
}

export class RegisteredUser implements RegisteredUserInterface{
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string; 
    email: string;
    mobile:string;
    city:string;
    state:string;
    sex:string;
    profession:string;
    organizationInformation:string;
    enabled:boolean;
    points: number;
    category: string;
    benefits: string;

    constructor(obj:RegisteredUserInterface){
        this.id=obj.id;
        this.username=obj.username;
        this.password=obj.password;
        this.firstName=obj.firstName;
        this.lastName=obj.lastName;
        this.email=obj.email;
        this.mobile=obj.mobile;
        this.city=obj.city;
        this.state=obj.state;
        this.sex=obj.sex;
        this.profession=obj.profession;
        this.organizationInformation=obj.organizationInformation;
        this.enabled=obj.enabled;
        this.points=obj.points;
        this.category=obj.category;
        this.benefits=obj.benefits;

    }
}