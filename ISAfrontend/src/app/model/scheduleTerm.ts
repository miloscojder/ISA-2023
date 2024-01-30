import { Equipment } from "./equipment";

interface ScheduleTermInterface {
    appointentId: number;
    registeredUserId: number;
    companyId: number;
    equipments: Equipment[];
}

export class ScheduleTerm implements ScheduleTermInterface{
    appointentId: number;
    registeredUserId: number;
    companyId: number;
    equipments: Equipment[];

    constructor(obj: ScheduleTermInterface){
        this.appointentId = obj.appointentId;
        this.companyId = obj.companyId;
        this.registeredUserId = obj.registeredUserId;
        this.equipments = obj.equipments;
    }
}