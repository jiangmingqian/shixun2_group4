
function selectAll() {
	var arr = document.getElementsByTagName("input");
	for (var i = 0; i < arr.length; i++) {
		if(arr[i].type=='checkbox'){
		   arr[i].checked = true;
		}
	}
	console.log("i的值是" + i);
	console.log("执行了selectAll方法");
}
function test(){
	location.href="getsql.jsp";
}
function selectAno(){
	var arr=document.getElementsByTagName("input");
	for (var i = 0; i < arr.length; i++) {
		if(arr[i].type=='checkbox'){
		   arr[i].checked = false;
		}
	}
	console.log("i的值是" + i);
	console.log("执行了selectAno方法");
}

function alertFun (){
	var formInfo = document.getElementById('formInfo');
	formInfo.style.display='block';
	formInfo.style.marginTop='-50px';
}

function del(obj)
{
	var deleteform = document.getElementById('deleteformInfo');
	deleteform.style.display='block';
	deleteform.style.marginTop='-50px';
}

function createTableCase(){ 
	var table1 = document.getElementsByClassName('table1')[0];
	var formInfo = document.getElementById('formInfo');
	let id = formInfo.id.value;
	let projectName = formInfo.projectName.value;
	let creator = formInfo.creator.value;
	let date = formInfo.date.value;
	var tr = document.createElement("tr");
	var tdcheckBox=document.createElement("td");
	var tdId = document.createElement("td");
	var tdProjectName = document.createElement("td");
	var tdCreator = document.createElement("td");
	var tdDate = document.createElement("td");
	var tdEdit=document.createElement("td");
	tdcheckBox.innerHTML = '<form method="post" action=""><input type="checkbox"></form>';
	tdId.innerHTML = id;
	tdProjectName.innerHTML = projectName;
	tdCreator.innerHTML = creator;
	tdDate.innerHTML = date;
	tdEdit.innerHTML = '<td><a href="javascript:void(0);"onclick="alertFun()">编辑</a><input type="button" value="删除" style="border:1px solid grey;background-color:white;text-align:center;width:30px;margin-left:16px;font-size:13px"></td>'
	table1.appendChild(tr);
	tr.appendChild(tdcheckBox);
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

function cancelTableCase(){
	var formInfo = document.getElementById('formInfo');
	formInfo.style.display='none';
	formInfo.id.value='';
	formInfo.casename.value='';
	formInfo.reqway.value='';
	formInfo.url.value='';
	formInfo.para.value='';
	formInfo.creator.value='';
	formInfo.date.value='';
}
function confirm(){
	var formInfo = document.getElementById('deleteformInfo');
	formInfo.style.display='none';
}
function cancel(){
	var formInfo = document.getElementById('deleteformInfo');
	formInfo.style.display='none';
}
















function alert (){
	var formInfo = document.getElementById('formInfo1');
	formInfo.style.display='block';
	formInfo.style.marginTop='-50px';
}

function createTableCase1(){ 
	var table1 = document.getElementsByClassName('table1')[0];
	var formInfo = document.getElementById('formInfo1');
	let id = formInfo.id.value;
	let projectName = formInfo.projectName.value;
	let owner = formInfo.owner.value;
	let date = formInfo.date.value;
	var tr = document.createElement("tr");
	var tdcheckBox=document.createElement("td");
	var tdId = document.createElement("td");
	var tdProjectName = document.createElement("td");
	var tdCreator = document.createElement("td");
	var tdDate = document.createElement("td");
	var tdEdit=document.createElement("td");
	tdcheckBox.innerHTML = '<form method="post" action=""><input type="checkbox"></form>';
	tdId.innerHTML = id;
	tdProjectName.innerHTML = projectName;
	tdCreator.innerHTML = owner;
	tdDate.innerHTML = date;
	tdEdit.innerHTML = '<td><a href="javascript:void(0);"onclick="alert()">编辑</a><input type="button" value="删除" style="border:1px solid grey;background-color:white;text-align:center;width:30px;margin-left:16px;font-size:13px"></td>'
	table1.appendChild(tr);
	tr.appendChild(tdcheckBox);
	tr.appendChild(tdId);
	tr.appendChild(tdProjectName);
	tr.appendChild(tdCreator);
	tr.appendChild(tdDate);
	tr.appendChild(tdEdit);
	formInfo.style.display='none';
	formInfo.id.value='';
	formInfo.projectName.value='';
	formInfo.owner.value='';
	formInfo.date.value='';
}

function cancelTableCase1(){
	var formInfo = document.getElementById('formInfo1');
	formInfo.style.display='none';
	formInfo.id.value='';
	formInfo.casename.value='';
	formInfo.reqway.value='';
	formInfo.url.value='';
	formInfo.para.value='';
	formInfo.owner.value='';
	formInfo.date.value='';
}
function confirm1(){
	var formInfo = document.getElementById('deleteformInfo');
	formInfo.style.display='none';
}
function cancel1(){
	var formInfo = document.getElementById('deleteformInfo');
	formInfo.style.display='none';
}