import { Equipment } from "./equipment";

interface ScheduleTermInterface {
    appointmentId: number;
    registeredUserId: number;
    companyId: number;
    equipmentIds: number[];
}

export class ScheduleTerm implements ScheduleTermInterface{
    appointmentId: number;
    registeredUserId: number;
    companyId: number;
    equipmentIds: number[] = [];

    constructor(obj: ScheduleTermInterface){
        this.appointmentId = obj.appointmentId;
        this.companyId = obj.companyId;
        this.registeredUserId = obj.registeredUserId;
        this.equipmentIds = obj.equipmentIds;
    }
}