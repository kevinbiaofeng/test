<div style="text-align:center">
	<h3>${dayTime?string('yyyy-MM-dd')} Statistical report</h3>
</div>
<br/>
<div>
	<b>日注册人数（Daily registration）：</b> ${dayData.userCount}
</div>
<br/>
<div>
	<b>日存款额（Daily gains）：</b> ${dayData.depositAmount} RMB
</div>
<br/>
<div>
	<b>日提款额（Daily paymengt）：</b> ${dayData.withdrawalAmount} RMB
</div>
<br/>
<div>
	<b>日投注量（Daily bet amount）：</b> ${dayData.totalBetAmount} RMB
</div>
<div>
	<table style="background-color: #f4f4f4; background-image: -moz-linear-gradient(center top , #f8f8f8, #eee);text-align: center;"  border="1">
		<tr>
			<td colspan="4"><b>Live Casino</b></td>
			<td colspan="5"><b>Slots</b></td>
			<td><b>Sports</b></td>
			<td><b>合计Total</b></td>
		</tr>
		<tr>
			<td width="100px;"><b>AG-Live</b></td>
			<td width="100px;"><b>AG-Slot</b></td>
			<td width="100px;"><b>AG-Poker</b></td>
			<td width="100px;"><b>AG-Fish</b></td>
			<td width="100px;"><b>PT</b></td>
			<td width="100px;"><b>PT2</b></td>
			<td width="100px;"><b>MG</b></td>
			<td width="100px;"><b>MG2</b></td>
			<td width="100px;"><b>ENDO</b></td>
			<td width="100px;"><b>SB</b></td>
			<td width="100px;">&nbsp;</td>
		</tr>
		<tr bgcolor="#fff">
			<td>${dayData.agBetAmount}</td>
			<td>${dayData.xinBetAmount}</td>
			<td>${dayData.qpBetAmount}</td>
			<td>${dayData.fishBetAmount}</td>
			<td>${dayData.ptBetAmount}</td>
			<td>${dayData.newPtBetAmount}</td>
			<td>${dayData.mgBetAmount}</td>
			<td>${dayData.newMgBetAmount}</td>
			<td>${dayData.endoBetAmount}</td>
			<td>${dayData.sbBetAmount}</td>
			<td>${dayData.totalBetAmount}</td>
		</tr>
	</table>
</div>
<br/>
<div>
	<b>日盈亏（Daily PROFIT & LOSS）：</b>
</div>
<div>
	<table style="background-color: #f4f4f4; background-image: -moz-linear-gradient(center top , #f8f8f8, #eee);text-align: center;"  border="1">
		<tr>
			<td colspan="4"><b>Live Casino</b></td>
			<td colspan="5"><b>Slots</b></td>
			<td><b>Sports</b></td>
			<td><b>合计Total</b></td>
			<td><b>活动Promotions Total</b></td>
			<td><b>日盈亏Daily PROFIT & LOSS</b></td>
		</tr>
		<tr>
			<td width="100px;"><b>AG-Live</b></td>
			<td width="100px;"><b>AG-Slot</b></td>
			<td width="100px;">AG-Poker</td>
			<td width="100px;">AG-Fish</td>
			<td width="100px;">PT</td>
			<td width="100px;">PT2</td>
			<td width="100px;">MG</td>
			<td width="100px;">MG2</td>
			<td width="100px;">ENDO</td>
			<td width="100px;">SB</td>
			<td width="100px;">&nbsp;</td>
			<td width="100px;">&nbsp;</td>
			<td width="100px;">&nbsp;</td>
		</tr>
		<tr bgcolor="#fff">
			<td>${-dayData.agNetAmount}</td>
			<td>${-dayData.xinNetAmount}</td>
			<td>${-dayData.qpNetAmount}</td>
			<td>${-dayData.fishNetAmount}</td>
			<td>${-dayData.ptNetAmount}</td>
			<td>${-dayData.newPtNetAmount}</td>
			<td>${-dayData.mgNetAmount}</td>
			<td>${-dayData.newMgNetAmount}</td>
			<td>${-dayData.endoNetAmount}</td>
			<td>${-dayData.sbNetAmount}</td>
			<td>${-dayData.totalNetAmount}</td>
			<td>${dayData.promotionAmount}</td>
			<td>${-dayData.totalNetAmount - dayData.promotionAmount}</td>
		</tr>
	</table>
</div>


<div>-----------------------------------------------------------</div>
<br/>
<div style="text-align:center">
	<h3>${dayTime?string('yyyy-MM')} total Statistical report</h3>
</div>
<br/>
<div>
	<b>累计存款Cumulative gains：</b> ${monthData['depositAmount']} RMB
</div>
<br/>
<div>
	<b>累计取款Cumulative payment：</b> ${monthData['withdrawalAmount']} RMB
</div>
<br/>
<div>
	<b>累计投注量Cumulative bet amount：</b> ${monthData['totalBetAmount']} RMB
</div>
<br/>
<div>
	<b>累计利润Cumulative PROFIT&LOSS：</b> ${-monthData['totalNetAmount'] - monthData['promotionAmount']} RMB
</div>
