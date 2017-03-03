/**
 * @author yuyang
 */
//tabit
function tabit(tabName,btnId,tabNumber,styleName){
	for(i=0;i<tabNumber;i++){
		document.getElementById(tabName+"_div"+i).style.display = "none";
		document.getElementById(tabName+"_btn"+i).className = styleName+"_b";
	};
	document.getElementById(tabName+"_div"+btnId).style.display = "";
	document.getElementById(tabName+"_btn"+btnId).className = styleName+"_a";
};