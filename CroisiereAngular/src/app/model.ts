export class Passager {
   
    id: number;	
	version:number; 
	nom:string;
	prenom:string;	
	dateNaissance:string;	
	
    constructor(id?:number, version?:number, nom?:string, prenom?:string, dateNaissance?:string){
        this.id=id;
        this.version=version;
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance=dateNaissance;
    }
}



