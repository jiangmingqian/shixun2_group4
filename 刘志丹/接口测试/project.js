
function alertFun (){
	var formInfo = document.getElementById('formInfo');
	formInfo.style.display='block';
	formInfo.style.marginTop='40px';
}
function createTable(){
	var table1 = document.getElementsByClassName('table1')[0];
	var formInfo = document.getElementById('formInfo');
	let id = formInfo.id.value;
	let projectName = formInfo.projectName.value;
	let creator = formInfo.creator.value;
	let date = formInfo.date.value;
	var tr = document.createElement("tr");
	var tdId = document.createElement("td");
	var tdProjectName = document.createElement("td");
	var tdCreator = document.createElement("td");
	var tdDate = document.createElement("td");
	var tdEdit=document.createElement("td");
	tdId.innerHTML = id;
	tdProjectName.innerHTML = projectName;
	tdCreator.innerHTML = creator;
	tdDate.innerHTML = date;
	tdEdit.innerHTML = '<td><a href="javascript:void(0);"onclick="alertFun()">编辑</a><input type="button" value="删除" style="border:1px solid grey;background-color:white;text-align:center;width:30px;margin-left:3px;"></td>'
	table1.appendChild(tr);
	tr.appendChild(tdId);
	tr.appendChild(tdProjectName);
	tr.appendChild(tdCreator);
	tr.appendChild(tdDate);
	tr.appendChild(tdEdit);
	formInfo.style.display='none';
	formInfo.id.value='';
	formInfo.projectName.value='';
	formInfo.creator.value='';
	formInfo.date.value='';
}
function cancelTable(){
	var formInfo = document.getElementById('formInfo');
	formInfo.style.display='none';
	formInfo.id.value='';
	formInfo.projectName.value='';
	formInfo.creator.value='';
	formInfo.date.value='';
}
