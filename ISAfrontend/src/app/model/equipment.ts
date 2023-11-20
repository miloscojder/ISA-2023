interface EquipmentInterface{
    id: number;
    name: string;
    type: string;
    description: string;

}
export class Equipment implements EquipmentInterface{
    id: number;
    name: string;
    type: string;
    description: string;
    constructor(obj:EquipmentInterface){
        this.id=obj.id;
        this.name=obj.name;
        this.type=obj.type;
        this.description=obj.description;
    }
}