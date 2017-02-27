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


//AJOUT TITRE

function inf_titre1() 
{
	document.getElementById("info_titre").style.display = "inline";
}

function inf_titre2() 
{
	document.getElementById("info_titre").style.display = "none";
	var value = document.getElementById("info_titre").value.length;
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