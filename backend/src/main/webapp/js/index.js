var Gereral = {
	fitDataSource : [{
			state : "Mon",
			oil : 1,
			gas : 2,
			coal : 3
		}, {
			state : "Tue",
			oil : 5,
			gas : 6,
			coal : 7
		}, {
			state : "Wed",
			oil : 0,
			gas : 0,
			coal : 0
		}, {
			state : "Thr",
			oil : 0,
			gas : 0,
			coal :
			0
		}, {
			state : "Fri",
			oil : 0,
			gas : 0,
			coal : 0
		}, {
			state : "Sat",
			oil : 0,
			gas : 0,
			coal :
			0
		}, {
			state : "Sun",
			oil : 0,
			gas : 0,
			coal :
			0
		}, ],

	render : function () {
		this.renderFit();
		this.renderFinance();
	},

	renderFinance : function () {
		var i = 0;
		$("#server-uptime-chart").dxChart({
			dataSource : [{
					id : ++i,
					sales : 1
				}, {
					id : ++i,
					sales : 2
				}, {
					id : ++i,
					sales : 3
				}, {
					id : ++i,
					sales : 4
				}, {
					id : ++i,
					sales : 5
				}, {
					id : ++i,
					sales : 4
				}, {
					id : ++i,
					sales : 5
				}, {
					id : ++i,
					sales : 6
				}, {
					id : ++i,
					sales : 7
				}, {
					id : ++i,
					sales : 6
				}, {
					id : ++i,
					sales : 5
				}, {
					id : ++i,
					sales : 4
				}, {
					id : ++i,
					sales : 5
				}, {
					id : ++i,
					sales : 4
				}, {
					id : ++i,
					sales : 4
				}, {
					id : ++i,
					sales : 3
				}, {
					id : ++i,
					sales : 4
				},
			],

			series : {
				argumentField : "id",
				valueField : "sales",
				name : "Sales",
				type : "bar",
				color : '#7c38bc'
			},
			commonAxisSettings : {
				label : {
					visible : false
				},
				grid : {
					visible : false
				}
			},
			legend : {
				visible : false
			},
			argumentAxis : {
				valueMarginsEnabled : true
			},
			valueAxis : {
				max : 12
			},
			equalBarWidth : {
				width : 11
			}
		});

	},
	renderFit : function () {
		jQuery(document).ready(function ($) {
			var dataSource = Gereral.fitDataSource;

			$("#fit").dxChart({
				equalBarWidth : false,
				dataSource : dataSource,
				commonSeriesSettings : {
					argumentField : "state",
					type : "bar"
				},
				series : [{
						valueField : "oil",
						name : "Sit ups",
						color : "#0e62c7"
					}, {
						valueField : "gas",
						name : "Push ups",
						color : "#2c2e2f"
					}, {
						valueField : "coal",
						name : "Squads",
						color : "#7c38bc"
					}
				],
				legend : {
					verticalAlignment : "bottom",
					horizontalAlignment : "center"
				},
			});
		});
	}
}

Gereral.render();
