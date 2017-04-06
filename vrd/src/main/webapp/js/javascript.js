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

function ConfirmPresse(idMetier) {
    if (confirm("Etes-vous sûr de vouloir supprimer définitivement cet article ?")) {
        window.location("deleteMetier?m="+idMetier);
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
	var value = document.getElementById("add_cp").value.length;
	result = value;
	if(result>2 && result<51)
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