interface CompanyInterface{
    id: number;
    name: string;
    address: string;
    description: string;
    averageGradeCompany: number;

}
export class Company implements CompanyInterface{
    id: number;
    name: string;
    address: string;
    description: string;
    averageGradeCompany: number;
    constructor(obj:CompanyInterface){
        this.id= obj.id;
        this.name=obj.name;
        this.address=obj.address;
        this.description=obj.description;
        this.averageGradeCompany=obj.averageGradeCompany;
    }
}