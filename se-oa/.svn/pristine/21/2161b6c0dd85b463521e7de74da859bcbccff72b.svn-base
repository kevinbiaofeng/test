$(function () {
	$('#allck').click(function() {
		var allck = $(this).attr("checked");
		if(allck == "checked"){
			$("input[name='ck']").attr("checked", true);
		}else{
			$("input[name='ck']").attr("checked", false);
		}
	});
	
});

function bindSkipClick(buttonId, url){
	jQuery("#" + buttonId).click(function() {
		window.location.href = url;
	});
}

function getParams(params) {
	if (params) {
		var str = "?";
		$.each(params, function(i, param) {
			str = str + param + "&";
		});
		return str.substring(0, str.length - 1);
	}
	return "";
}

function bindDelAllClick(buttonId, url, params){
	$("#"+buttonId).click(function() {
		var ckValues =[];
		$('input[name="ck"]:checked').each(function(){
		  ckValues.push($(this).val());
		});
		if(ckValues.length == 0){
			BUI.Message.Alert('请选择一个删除项！','warning');
		}else{
			delRow(ckValues, url, params);
		}
	});
}

function commonPageFormSubmit(formId, pageNo){
	var form = $("#" + formId);
	var actionUrl = form.attr("action");
	$("#pageNo").remove();
	if(actionUrl.indexOf("&") > 1){
		actionUrl += "&pageNo=" + pageNo;
	}else{
		actionUrl += "?pageNo=" + pageNo;
	}
	form.attr("action", actionUrl);
	form.attr("method", "POST");
	form.submit();
}

function changeTab(name){
	$(".nav-tabs li").each(function(){
		var id = $(this).attr("id");
		if(name == id){
			$(this).attr("class", "active");
			$("#" + id + "Panel").show();
		}else{
			$(this).attr("class", "");
			$("#" + id + "Panel").hide();
		}
    });
}

function createDataListRow(tableId, formId, editMethodParam, delMethodParam){
	var row = $("#" + tableId + "_row").val();
	var tableAppendTr = "";
	var tableRowCount = $("#" + tableId + " tr").length;
	var trData = "";
	var count = "";
	if(row != ""){
		count = row - 1;
	}else{
		count = tableRowCount - 1;
	}
	
	var trHtmlCode = "<tr>";
	var colomnCount = 0;
	
	var buttonText = "";
	$("#" + tableId + " tr :first th").each(function () {
		var id = $(this).attr("id");
		if(id != null){
			var inputName = id.substring(0, id.length - 2);
    		var input = $("#" + tableId + "_1").find("#" + inputName + "_1");
    		
    		var type = input.attr("type");
			if(type == "text"){
				trHtmlCode += "<td>";
				trHtmlCode += input.val();
				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count) + "]." + inputName + "' value='" + input.val() + "'/>";
				trHtmlCode += "</td>";
			}else if(type == "hidden"){
				trHtmlCode += "<td style='display:none'>";
				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count) + "]." + inputName + "' value='" + input.val() + "'/>";
				trHtmlCode += "</td>";
			}else if(type == "select"){
				trHtmlCode += "<td>";
				if(input.val() != ""){
					trHtmlCode += input.find("option:selected").text();
    				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count) + "]." + inputName + "' value='" + input.val() + "'/>";
				}
				trHtmlCode += "</td>";
			}else if(type == "checkbox"){
				trHtmlCode += "<td>";
				var vals = [];
				var texts = [];
				var fcount = 0;
				
				$("input[name='" + inputName + "_1']:checked").each(function(){
					vals.push($(this).val());
					texts.push($(this).next().text());
					++fcount;
				});
				if(fcount > 0){
					trHtmlCode += texts;
    				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count) + "]." + inputName + "' value='" + vals + "'/>";
				}
				
				trHtmlCode += "</td>";
			}else if(type == "radio"){
				trHtmlCode += "<td>";
				$("input[name='" + inputName + "_1']:checked").each(function(){
					if($(this).attr("checked") == "checked"){
						trHtmlCode += $(this).next().text();
        				trHtmlCode += "<input type='hidden' name='" + tableId + "["+ (count + 1) + "]." + inputName + "' value='" + $(this).val() + "'/>";
						return false;
					}
				});
				trHtmlCode += "</td>";
			}
			++colomnCount;
		}else{
			if(row != ""){
				buttonText = $("#" + tableId + " tbody tr").eq(row-1).find("td:last").html();
			}else{
				buttonText = "<button type='button' onclick='editDataListRow(\"" + tableId + "\", \"" + (count + 1) + "\");" + editMethodParam + "'><i class='icon-edit'></i>编辑</button>  <button type='button' onclick='delDataListRow(\"" + tableId + "\", \"" + (count + 1) + "\", \"" + formId + "\");leo(\""+tableId+"\"); " + delMethodParam + "'><i class='icon-remove-sign'></i>删除</button>";
			}
		}
	});
	trHtmlCode += "<td>"+buttonText+"</td>";
	trHtmlCode += "</tr>";
	if(row != ""){
		delDataListRow(tableId, row, formId);
		if(row == 1 && $("#" + tableId + " tbody tr").length == 0){
			$("#" + tableId + " tbody").append(trHtmlCode);
		}else if(row == 1 && $("#" + tableId + " tbody tr").length > 0){
			$("#" + tableId + " tbody tr").eq(row - 1).before(trHtmlCode);
		}else {
			$("#" + tableId + " tbody tr").eq(row - 2).after(trHtmlCode);
		}
	}else{
		$("#" + tableId + " tbody").append(trHtmlCode);
	}
	dataListReset(formId, tableId);
}

function editDataListRow(tableId, i){
	$("#" + tableId).find("tr").eq(i).find("td").each(function () {
		var dataInput = $(this).find("input");
		var name = dataInput.attr("name");
		if(name != null){
			var inputName = name.substring(name.indexOf(".") + 1, name.length);
			var input = $("#" + inputName + "_1");
			var type = input.attr("type");
			if(type == "hidden" ||type == "text" || type == "select"){
				input.val(dataInput.val());
			}else if(type == "radio"){
				$("input[name='" + inputName + "_1']").each(function(){
					if($(this).val() == dataInput.val()){
						$(this).attr("checked", true);
						return false;
					}
				});
			}else if(type == "checkbox"){
				var ss = dataInput.val().split(",");
				$("input[name='" + inputName + "_1']").each(function(){
					var check = $(this);
					check.attr("checked", false);
					$.each(ss, function(i, k) {
						if(check.val() == ss[i]){
							check.attr("checked", true);
    						return false;
    					}
		            });
				});
				
			}
			
		}
	});
	$("#" + tableId + "_row").val(i);
}

function delDataListRow(tableId, i, formId){
	var tb = document.getElementById(tableId);
	tb.deleteRow(i);
	dataListReset(formId, tableId);
}

function leo(tableId){
	$("#" + tableId).find("tr").each(function (i) {
        $(this).find("td").each(function (j) {
        	if($(this).find("input").attr("type") == "hidden"){
        		var name = $(this).find("input").attr("name");
        		$(this).find("input").attr("name", name.substring(0, name.indexOf("[")+1) + (i-1) + name.substring(name.indexOf("]"), name.length));
        	}
        	$(this).find(":button").each(function () {
        		if($(this).text() == "编辑"){
        			$(this).attr("onclick", "editDataListRow('"+tableId+"','"+(i)+"');");
        		}else if($(this).text() == "删除"){
        			$(this).attr("onclick", "delDataListRow('"+tableId+"','"+(i)+"');leo('"+tableId+"')");
        		}
        	});
        });
    });
}

function dataListReset(formId, tableId){
	$("#" + formId)[0].reset();
	$("#" + formId).find("#" + tableId + "_row").val("");
	$("#" + formId).find("input[type='radio']").attr("checked", false);
	$("#" + formId).find("input[type='checkbox']").attr("checked", false);
}