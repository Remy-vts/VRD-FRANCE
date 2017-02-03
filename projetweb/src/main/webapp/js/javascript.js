function ConfirmMessage(id) {
       if (confirm("Etes-vous sûr de vouloir supprimer définitivement cet article ?")) {
           window.location("deleteArticle?art="+id);
       }
   }

//AJOUT PRIX

function inf_prix1() 
{
	document.getElementById("info_prix").style.display = "inline";
}

function inf_prix2() 
{
	document.getElementById("info_prix").style.display = "none";
	var value = document.getElementById("ajout_prix").value.length;
	result = value;
	if(result>1 && result<7)
	{
		document.getElementById("check_prix1").style.display = "inline";
		document.getElementById("check_prix2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_prix1").style.display = "none";
		document.getElementById("check_prix2").style.display = "inline";
		return false;
	}
}

//AJOUT MARQUE

function inf_marque1() 
{
	document.getElementById("info_marque").style.display = "inline";
}

function inf_marque2() 
{
	document.getElementById("info_marque").style.display = "none";
	var value = document.getElementById("ajout_marque").value.length;
	result = value;
	if(result>1 && result<16)
	{
		document.getElementById("check_marque1").style.display = "inline";
		document.getElementById("check_marque2").style.display = "none";
		return true;
	}
	else
	{
		document.getElementById("check_marque1").style.display = "none";
		document.getElementById("check_marque2").style.display = "inline";
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
	var value = document.getElementById("ajout_lien").value.length;
	result = value;
	if(result>1 && result<256)
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

//ZOOM consultation article

$("zoom_01").elevateZoom();