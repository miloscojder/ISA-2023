import { Calendar } from "./calendar";
import { Company } from "./company";
import { Equipment } from "./equipment";
import { RegisteredUser } from "./registeredUser";

interface appointmentInterface{
    id: number;
    date: Date;
    duration: number;
    isFree: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    isRegisteredUserCome: boolean;
    registeredUser: RegisteredUser;
    company: Company;
    calendar: Calendar;
    equipments: Equipment[];
}
export class Appointment implements appointmentInterface{
    id: number;
    date: Date;
    duration: number;
    isFree: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    isRegisteredUserCome: boolean;
    registeredUser: RegisteredUser;
    company: Company;
    calendar: Calendar;
    equipments: Equipment[];
    constructor(obj: appointmentInterface){
        this.id = obj.id;
        this.date = obj.date;
        this.duration = obj.duration;
        this.isFree = obj.isFree;
        this.reservationStart = obj.reservationStart;
        this.reservationEnd = obj.reservationEnd;
        this.isRegisteredUserCome = obj.isRegisteredUserCome;
        this.registeredUser = obj.registeredUser;
        this.company = obj.company;
        this.calendar = obj.calendar;
        this.equipments = obj.equipments;
    }
}