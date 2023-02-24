import { NgComponentOutlet } from "@angular/common";

export class Passager {
   
    id: number;	
	version:number; 
	nom:string;
	prenom:string;	
	dateNaissance:string;
    reservation: Reservation;	
	
    constructor(id?:number, version?:number, nom?:string, prenom?:string, 
        dateNaissance?:string, reservation?:Reservation){
        this.id=id;
        this.version=version;
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance=dateNaissance;
    }
}

export class Reservation{
    id: number;	
	version:number;
    prix : number;
    date: string;
    classe: number;
    passagers:Array<Passager>=new Array<Passager>;
    client: Client;
    voyage: Voyage;

    constructor(id?: number,version?: number,prix?:number,
        date?: string, classe?: number,client?:Client,passagers?: Array<Passager>,voyage?: Voyage){
            this.id = id;
            this.version = version;
            this.prix = prix;
            this.date=date;
            this.classe=classe;
            this.passagers=passagers;
            this.client = client;
            this.voyage=voyage;
        }

}

export class Voyage{
    id: number;	
	version:number; 
    prix: number;
    distance: number;
    duree:number;
    capacite:number;
    etapes:Array<Etape>;
    reservations:Array<Reservation>;
    avis:Array<Avis>;

    constructor(id?:number,version?:number,prix?:number,distance?:number,
        duree?:number, capacite?:number,etapes?:Array<Etape>,
        reservations?:Array<Reservation>,avis?:Array<Avis>){
            this.id=id;
            this.version =version;
            this.prix = prix;
            this.distance = distance;
            this.duree = duree;
            this.capacite = capacite;
            this.etapes= etapes;
            this.reservations =reservations;
            this.avis = avis; 
    }
}

export class Etape{
    id: number;	
	version:number; 
    depart:string;
    arrivee:string;
    planeteDepart:Planete;
    planeteArrivee:Planete;
    voyage: Voyage;
    constructor(id?: number, version?:number, depart?: string, arrivee?:string, planeteDepart?:Planete,
        planeteArrivee?:Planete, voyage?: Voyage){
            this.id=id;	
            this.version=version; 
            this.depart=depart;
            this.arrivee=arrivee;
            this.planeteDepart=planeteDepart;
            this.planeteArrivee=planeteArrivee;
            this.voyage=voyage;
        }

}

export class Planete{
    id: number;	
	version:number;
    nom:string;
    positionX:number;
    positionY:number;
    positionZ:number;

    constructor(id?:number,version?:number,nom?:string,positionX?:number,
        positionY?:number,positionZ?:number)
        {
            this.id=id;
            this.version=version;
            this.nom=nom;
            this.positionX=positionX;
            this.positionY=positionY;
            this.positionZ=positionZ;
        }
}

export class Compte{
    id: number;	
	version:number;
    nom:string;
    prenom:string;
    email:string;
    adresse:Adresse;
    utilisateur: Utilisateur;
    
    constructor(id?:number,version?:number,nom?:string,prenom?:string,
        email?:string, adresse?:Adresse){
            this.id=id;
            this.version=version;
            this.nom=nom;
            this.prenom=prenom;
            this.email=email;
            this.adresse=adresse;
            this.utilisateur=this.utilisateur
        }
}

export class Adresse{
    planete:string;
    district:string;
    ville:string;
    rue:string;
    constructor(planete?:string,district?:string,ville?:string,rue?:string){
        this.planete=planete;
        this.district=district;
        this.ville=ville;
        this.rue=rue;
    }
}

export class Utilisateur{
    id:number;
    identifiant:string;
    motDePasse:string;
    nom:string;
    prenom:string;
    role:string;
    compte:Compte;

    constructor(id?:number,identifiant?:string,motDePasse?:string,nom?:string,prenom?:string,role?:string,compte?:Compte){
        this.id=id;
        this.identifiant=identifiant;
        this.motDePasse=motDePasse;
        this.nom=nom;
        this.prenom=prenom;
        this.role=role;
        this.compte=compte;
    }
}

export class Client extends Compte{
    reservations:Array<Reservation>;
    listeAvis:Array<Avis>;

    constructor(id?:number,version?:number,nom?:string,prenom?:string,
        email?:string, adresse?:Adresse,reservations?: Array<Reservation>,listeAvis?:Array<Avis>){
        super(id,version,nom,prenom,email,adresse);
        this.reservations=reservations;
        this.listeAvis=listeAvis;
    }

}
export class Admin extends Compte{
    constructor(id?:number,version?:number,nom?:string,prenom?:string,
        email?:string, adresse?:Adresse){
        super(id,version,nom,prenom,email,adresse);
    }
}
export class Avis{
    id:number;
    version:number;
    note:number;
    commentaire:string;
    client:Client;
    voyage:Voyage;

    constructor(id?:number,version?:number,note?:number,commentaire?:string,
        client?:Client,voyage?:Voyage){
            this.id=id;
            this.version=version;
            this.note=note;
            this.commentaire=commentaire;
            this.client=client;
            this.voyage=voyage
        }

}

