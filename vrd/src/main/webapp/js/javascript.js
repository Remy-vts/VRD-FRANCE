function ConfirmMessage(idChantier) {
       if (confirm("Etes-vous sûr de vouloir supprimer définitivement cette réalisation ?")) {
           window.location("deleteChantier?c="+idChantier);
       }
   }

function ConfirmPresse(idPresse) {
    if (confirm("Etes-vous sûr de vouloir supprimer définitivement cet article ?")) {
        window.location("deletePresse?p="+idPresse);
    }
}

function ConfirmOffre(idOffre) {
    if (confirm("Etes-vous sûr de vouloir supprimer définitivement cette offre ?")) {
        window.location("deleteOffre?o="+idOffre);
    }
}

function ConfirmDirigeant(idDirigeant) {
    if (confirm("Etes-vous sûr de vouloir supprimer définitivement ce dirigeant ?")) {
        window.location("deleteDirigeant?d="+idDirigeant);
    }
}


//AJOUT TITRE

function inf_titre1() 
{
	document.getElementById("info_titre").style.display = "inline";
}

function inf_titre2() 
{
	document.getElementById("info_titre").style.display = "none";
	var value = document.getElementById("add_titre").value.length;
	result = value;
	if(result>4 && result<51)
	{
		document.getElementById("check_titre1").style.display = "inline";
		document.getElementById("check_titre2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_titre1").style.display = "none";
		document.getElementById("check_titre2").style.display = "inline";
		return false;
	}
}

//AJOUT VILLE

function inf_ville1() 
{
	document.getElementById("info_ville").style.display = "inline";
}

function inf_ville2() 
{
	document.getElementById("info_ville").style.display = "none";
	var value = document.getElementById("add_ville").value.length;
	result = value;
	if(result>2 && result<51)
	{
		document.getElementById("check_ville1").style.display = "inline";
		document.getElementById("check_ville2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_ville1").style.display = "none";
		document.getElementById("check_ville2").style.display = "inline";
		return false;
	}
}

//AJOUT CODE POSTAL

function inf_cp1() 
{
	document.getElementById("info_cp").style.display = "inline";
}

function inf_cp2() 
{
	document.getElementById("info_cp").style.display = "none";
	var value = document.getElementById("add_cp").value;
	var chiffres = new String(value);
	// Enlever tous les charactères sauf les chiffres
	chiffres = chiffres.replace(/[^0-9]/g, '');
	result = chiffres.length;
	if(result>4 && result<6)
	{
		document.getElementById("check_cp1").style.display = "inline";
		document.getElementById("check_cp2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_cp1").style.display = "none";
		document.getElementById("check_cp2").style.display = "inline";
		return false;
	}
}

//AJOUT MO

function inf_mo1() 
{
	document.getElementById("info_mo").style.display = "inline";
}

function inf_mo2() 
{
	document.getElementById("info_mo").style.display = "none";
	var value = document.getElementById("add_mo").value.length;
	result = value;
	if(result>2 && result<51)
	{
		document.getElementById("check_mo1").style.display = "inline";
		document.getElementById("check_mo2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_mo1").style.display = "none";
		document.getElementById("check_mo2").style.display = "inline";
		return false;
	}
}

//AJOUT client

function inf_client1() 
{
	document.getElementById("info_client").style.display = "inline";
}

function inf_client2() 
{
	document.getElementById("info_client").style.display = "none";
	var value = document.getElementById("add_client").value.length;
	result = value;
	if(result>2 && result<51)
	{
		document.getElementById("check_client1").style.display = "inline";
		document.getElementById("check_client2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_client1").style.display = "none";
		document.getElementById("check_client2").style.display = "inline";
		return false;
	}
}

//AJOUT MISSION

function inf_mission1() 
{
	document.getElementById("info_mission").style.display = "inline";
}

function inf_mission2() 
{
	document.getElementById("info_mission").style.display = "none";
	var value = document.getElementById("add_mission").value.length;
	result = value;
	if(result>2 && result<51)
	{
		document.getElementById("check_mission1").style.display = "inline";
		document.getElementById("check_mission2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_mission1").style.display = "none";
		document.getElementById("check_mission2").style.display = "inline";
		return false;
	}
}


//AJOUT MEDIA

function inf_media1() 
{
	document.getElementById("info_media").style.display = "inline";
}

function inf_media2() 
{
	document.getElementById("info_media").style.display = "none";
	var value = document.getElementById("add_media").value.length;
	result = value;
	if(result>3 && result<51)
	{
		document.getElementById("check_media1").style.display = "inline";
		document.getElementById("check_media2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_media1").style.display = "none";
		document.getElementById("check_media2").style.display = "inline";
		return false;
	}
}

//AJOUT LIEN

function inf_lien1() 
{
	document.getElementById("info_lien").style.display = "inline";
}

function inf_lien2() 
{
	document.getElementById("info_lien").style.display = "none";
	var value = document.getElementById("add_lien").value.length;
	result = value;
	if(result>4 && result<201)
	{
		document.getElementById("check_lien1").style.display = "inline";
		document.getElementById("check_lien2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_lien1").style.display = "none";
		document.getElementById("check_lien2").style.display = "inline";
		return false;
	}
}


//AJOUT NOM

function inf_nom1() 
{
	document.getElementById("info_nom").style.display = "inline";
}

function inf_nom2() 
{
	document.getElementById("info_nom").style.display = "none";
	var value = document.getElementById("add_nom").value.length;
	result = value;
	if(result>2 && result<51)
	{
		document.getElementById("check_nom1").style.display = "inline";
		document.getElementById("check_nom2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_nom1").style.display = "none";
		document.getElementById("check_nom2").style.display = "inline";
		return false;
	}
}

//AJOUT FONCTION

function inf_fonction1() 
{
	document.getElementById("info_fonction").style.display = "inline";
}

function inf_fonction2() 
{
	document.getElementById("info_fonction").style.display = "none";
	var value = document.getElementById("add_fonction").value.length;
	result = value;
	if(result>2 && result<51)
	{
		document.getElementById("check_fonction1").style.display = "inline";
		document.getElementById("check_fonction2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_fonction1").style.display = "none";
		document.getElementById("check_fonction2").style.display = "inline";
		return false;
	}
}


//AJOUT PRESENTATION

function inf_present1() 
{
	document.getElementById("info_presentation").style.display = "inline";
}

function inf_present2() 
{
	document.getElementById("info_presentation").style.display = "none";
	var value = document.getElementById("add_presentation").value.length;
	result = value;
	if(result>39 && result<201)
	{
		document.getElementById("check_presentation1").style.display = "inline";
		document.getElementById("check_presentation2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_presentation1").style.display = "none";
		document.getElementById("check_presentation2").style.display = "inline";
		return false;
	}
}

//AJOUT METIER

function inf_metier1() 
{
	document.getElementById("info_metier").style.display = "inline";
}

function inf_metier2() 
{
	document.getElementById("info_metier").style.display = "none";
	var value = document.getElementById("add_metier").value.length;
	result = value;
	if(result>2 && result<51)
	{
		document.getElementById("check_metier1").style.display = "inline";
		document.getElementById("check_metier2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_metier1").style.display = "none";
		document.getElementById("check_metier2").style.display = "inline";
		return false;
	}
}

//AJOUT REF

function inf_ref1() 
{
	document.getElementById("info_ref").style.display = "inline";
}

function inf_ref2() 
{
	document.getElementById("info_ref").style.display = "none";
	var value = document.getElementById("add_ref").value.length;
	result = value;
	if(result>2 && result<13)
	{
		document.getElementById("check_ref1").style.display = "inline";
		document.getElementById("check_ref2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_ref1").style.display = "none";
		document.getElementById("check_ref2").style.display = "inline";
		return false;
	}
}

//AJOUT METIER

function inf_poste1() 
{
	document.getElementById("info_poste").style.display = "inline";
}

function inf_poste2() 
{
	document.getElementById("info_poste").style.display = "none";
	var value = document.getElementById("add_poste").value.length;
	result = value;
	if(result>4 && result<51)
	{
		document.getElementById("check_poste1").style.display = "inline";
		document.getElementById("check_poste2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_poste1").style.display = "none";
		document.getElementById("check_poste2").style.display = "inline";
		return false;
	}
}

//MODIFICATION TELEPHONE

function inf_telephone1() 
{
	document.getElementById("info_telephone").style.display = "inline";
}

function inf_telephone2() 
{
	document.getElementById("info_telephone").style.display = "none";
	var value = document.getElementById("add_telephone").value;
	var chiffres = new String(value);
	// Enlever tous les charactères sauf les chiffres
	chiffres = chiffres.replace(/[^0-9]/g, '');
	result = chiffres.length;
	if(result>9 && result<11)
	{
		document.getElementById("check_telephone1").style.display = "inline";
		document.getElementById("check_telephone2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_telephone1").style.display = "none";
		document.getElementById("check_telephone2").style.display = "inline";
		return false;
	}
}

//MODIFICATION MAIL

function inf_mail1() 
{
	document.getElementById("info_mail").style.display = "inline";
}

function inf_mail2(champ) 
{
	document.getElementById("info_mail").style.display = "none";
	var regex = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
	if(regex.test(champ.value))
	{
		document.getElementById("check_mail1").style.display = "inline";
		document.getElementById("check_mail2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_mail1").style.display = "none";
		document.getElementById("check_mail2").style.display = "inline";
		return false;
	}
}

//AJOUT PRENOM

function inf_prenom1() 
{
	document.getElementById("info_prenom").style.display = "inline";
}

function inf_prenom2() 
{
	document.getElementById("info_prenom").style.display = "none";
	var value = document.getElementById("add_prenom").value.length;
	result = value;
	if(result>1 && result<51)
	{
		document.getElementById("check_prenom1").style.display = "inline";
		document.getElementById("check_prenom2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_prenom1").style.display = "none";
		document.getElementById("check_prenom2").style.display = "inline";
		return false;
	}
}

//AJOUT MSG

function inf_msg1() 
{
	document.getElementById("info_msg").style.display = "inline";
}

function inf_msg2() 
{
	document.getElementById("info_msg").style.display = "none";
	var value = document.getElementById("add_msg").value.length;
	result = value;
	if(result>1 && result<401)
	{
		document.getElementById("check_msg1").style.display = "inline";
		document.getElementById("check_msg2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_msg1").style.display = "none";
		document.getElementById("check_msg2").style.display = "inline";
		return false;
	}
}