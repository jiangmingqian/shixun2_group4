
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
	let casename = formInfo.casename.value;
	let reway = formInfo.reway.value;
	let url = formInfo.url.value;
	let para =formInfo.para.value;
	let creator = formInfo.creator.value;
	let date = formInfo.date.value;
	var tr = document.createElement("tr");
	var tdcheckBox=document.createElement("td");
	var tdId = document.createElement("td");
	var tdCasename = document.createElement("td");
	var tdReway = document.createElement("td");
	var tdUrl = document.createElement("td");
	var tdPara = document.createElement("td");
	var tdCreator = document.createElement("td");
	var tdDate = document.createElement("td");
	var tdEdit=document.createElement("td");
	tdcheckBox.innerHTML = '<form method="post" action=""><input type="checkbox"></form>';
	tdId.innerHTML = id;
	tdCasename.innerHTML = casename;
	tdReway.innerHTML = reway;
	tdUrl.innerHTML = url;
	tdPara.innerHTML = para;
	tdCreator.innerHTML = creator;
	tdDate.innerHTML = date;
	tdEdit.innerHTML = '<td><a href="javascript:void(0);" onclick="alertFun()">编辑</a><a href="javascript:;" onclick="del(this);">删除</a></td>'
	table1.appendChild(tr);
	tr.appendChild(tdcheckBox);
	tr.appendChild(tdId);
	tr.appendChild(tdCasename);
	tr.appendChild(tdReway);
	tr.appendChild(tdUrl);
	tr.appendChild(tdPara);
	tr.appendChild(tdCreator);
	tr.appendChild(tdDate);
	tr.appendChild(tdEdit);
	formInfo.style.display='none';
	formInfo.id.value='';
	formInfo.casename.value='';
	formInfo.reway.value='';
	formInfo.url.value='';
	formInfo.para.value='';
	formInfo.creator.value='';
	formInfo.date.value='';
}
function cancelTableCase(){
	var formInfo = document.getElementById('formInfo');
	formInfo.style.display='none';
	formInfo.id.value='';
	formInfo.casename.value='';
	formInfo.reway.value='';
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