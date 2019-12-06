 ***On souhaite Créer une application distribuée qui permet de gérer le transport des cargaisons contenant
    des marchandises.
	
		**Chaque cargaison contient plusieurs marchandises.
		
		**Il existe deux types de cargaisons : les cargaisons routières et aériennes.
		
		**Chaque marchandise est définie par :  
			.un numéro de type Long (Auto Incrémenté), 
			.le nom de la marchandise, 
			.son poids,
			.son volume.
			
		**Chaque cargaison est définie par :
			.une référence de type String, 
			.la distance de parcours,
			.la date de livraison.

		**Une cargaison routière est une cargaison qui possède en plus la température de conservation.
		
		**Une cargaison aérienne est une cargaison qui possède en plus un poids maximal qui ne doit pas 
		être dépassé.
		
		
	==>La couche metier de cette application est basé sur EJB(Session et Entity)
	
	==>Creation d'une application qui permet un accès distant aux services
		métiers qui contient deyx types de services :
			**: Un web service SOAP avec JAXWS.
			**: Un web service REST FULL basé sur JAXRS.
		
@==>Technologie Utilisees : Java8,EJB3.0(EJB Entity,EJB Session),JPA,HIBERNATE,MySql,WildFly 8.1,Eclipse
							SOAPUI,JAX-WS,JAX-RS

		