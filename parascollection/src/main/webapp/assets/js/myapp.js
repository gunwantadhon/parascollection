$(function() {
	
	
	switch (menu) {
	case'Contact':
		$('#contact').addClass('active');
		break;
	case'About':
		$('#about').addClass('active');
		break;
	case'Home':
		$('#home').addClass('active');
		break;
	

	case'View Products':
		$('#products').addClass('active');
		break;
		
	case'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:

		$('#home').addClass('active');
				break;

	}
	
	
	// dismissing the product after 3 seconds
	var $alert = $('.alert');

	if ($alert.length) {
		setTimeOut(function() {
			$alert.fadeOut('slow')
		}, 3000)
	}

	
	// it comes from listProducts.jsp
	// -----------------------------------------------------
	// this is product dataTable
	// -----------------------------------------------------
	$table = $('#productListTable');
	// execute the bellow code only where we have this table
	if ($table.length) {
	 console.log("this is inside ");
	var jsonUrl = '';
	if (window.categoryid == '') 
	{
	jsonUrl = window.contextRoot + '/json/data/all/products';
	} 
	else 
	{
	jsonUrl = window.contextRoot + '/json/data/category/' +3+ '/products';// ------
	}

	}

	// end of productListTable
	
	//
	
	
	$table.DataTable({// -1 represents all
		lengthMenu :[
			[ 3, 5, 10, -1 ],
			[ '3 products','5 products','10 products ','All Products']
			],
	pageLength : 5,// default length is 5
	
	// data:products
	ajax : {
		url : jsonUrl,   // data comes frm url
		dataSrc : ''     // destination
		},
		
		columns : [
		{
		data : 'code',  // datamember of the product table
		mRender : function(data, row, row) 
		{
		return '<img src="'
		+window.contextRoot
		+'/resources/images/'
		+ data+ '.jpg" class="dataTableImg"/>';
		}// here window is the object and contextRoot is the varibale
		},
		{
		data :'name'
		},
		{
		data :'brand'
		},
		{
		data :'unitPrice',
		mRender : function(data, type, row) {  // i want RS sysmbol so i want
												// this code
		return '&#8377; ' + data
		}
		},
		{
		data :'quantity',
		mRender : function(data, type, row) {
		if (data < 1) {
		return '<span style="color:red"> out of stock <span/>';
		}
		return data;
		}
		},
		
		{
		data :'id',
		bSortable : false,
		mRender : function(data, type, row) {
		var str = '';
		str += '<a href="'
			+window.contextRoot
			+ '/show/'+ data
			+ '/product" class="btn btn-primary">View</a>&#160;';
		if(row.quantity < 1)
		{
		str += '<a href="javascript:void(0)" class="btn btn-success disabled">disaboed<span class="glyphicon glyphicon-shoppingcart"></span></a>';
		} 
		else 
		{
			str += '<a href="'+window.contextRoot
			+'/cart/add/'
			+data
			+'/product" class="btn btn-success">add Cart </a>';
		}
		return str;
		}
		}
		]
		});
			
	// -------------end product here





//admin product here


$adminProductsTable= $('#adminProductsTable');
// execute the bellow code only where we have this table

if ($adminProductsTable.length) 
{
var jsonUrl = window.contextRoot+'/json/data/admin/all/products';
if (window.categoryid == '') 
{
jsonUrl = window.contextRoot + '/json/data/all/products';
} 
else 
{
jsonUrl = window.contextRoot + '/json/data/category/' +3+ '/products';// ------
}

}
// end of productListTable

//


/*$adminProductsTable.DataTable({// -1 represents all
	lengthMenu :[
		[10,30,50,-1],
		[ '10 products','30 products','50 products ','All Products']],
pageLength :30,// default length is 5

// data:products
ajax : {
	
	url : jsonUrl,   // data comes frm url
	dataSrc : ''  // destination
	},
	
	columns : [
	{
	data : 'id',  // datamember of the product table
	
	},
	{
	data :'code',
	mRender:function(data,row,row)
	{
		return '<img src="'
		+window.contextRoot
		+'/resources/images/'
		+data
		+'.jpg" alt="image" class="adminDataTableImg"/>';
		
	}
	},
	{
	data :'name'
	},
	{
	data :'brand',


	},
	{
	data :'quantity',
	mRender : function(data, type, row) {
	if (data < 1) {
	return '<span style="color:red"> out of stock <span/>';
	}
	return data;
	}
	},
	{

		data : 'unitPrice',
		mRender : function(data, type, row) {
			return '&#8377; ' + data

		}

	},
	
	{
	data :'active',
	bSortable : false,
	mRender : function(data, type, row) {
		
	     var str = '';
	     str +='<label class="switch">'; 
	
	if(data)
	{
	str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
	} 
	else 
	{
		str +='<input type="checkbox"  value="'+row.id+'"/>';

	}
	
	str +='<div class="slider"></div></label>';
	return str;
	}
	} , 
	
	
	{
		data :'id',
		bSortable : false,
		mRender : function(data, type, row) {
		      var str = '';
		       str += '<a href="'
			   +window.contextRoot
			   + '/manage/'+ data
			   + '/product" class="btn btn-warning">';
		
		       
		       str+='<span class="glyphicon glyphicon-pencil">o</span></a>';
		return str;
		}
		} 
	
	
	
	
	] ,
	
	//after closing the all column we are adding bootbox for loading the table befor the ajax call
	//using the initCompletefunction so alert will work
	//for the alert bootbox while loading the table
	initComplete:function()
	{
		
		var api=this.api();
		api.$('.switch input[type="checkbox"]')
		.on(
				'change',
				function() {
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dMsg = (checked) ? 'You want to activate the product'
							: 'You want to deactivate product?';

					var value = checkbox.prop('value');

					bootbox.confirm(
							{
                           	size : 'medium',
								title : 'Product activation and deactivation',
								message : dMsg,
								callback : function(confirmed) {
									
									
									if (confirmed) {
										console.log(value);
										var activationUrl=window.contextRoot+'/manage/product/'+value+'/activation';
										
										$.post(activationUrl,function(data)
												{
											
											bootbox.alert(
													{
												size : 'medium',
												title : 'information',
												message : data
														
											          });
										         });
										
									                } 
									
									else 
									{
										checkbox.prop('checked', !checked)
									}
								                                  }
							})
				});
		
		
		
	}
*/


// ----------------------------------------
// data table for adming
// ----------------------------------------
$adminProductsTable = $('#adminProductsTable');
// execute the bellow code only where we have this table
if ($adminProductsTable.length)
{


var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

if (window.categoryid == '') {
	jsonUrl = window.contextRoot + '/json/data/all/products';
} else {
	jsonUrl = window.contextRoot + '/json/data/category/' + 3
			+ '/products';
}
$adminProductsTable.DataTable({
			lengthMenu : [
					[ 10, 30, 50, -1 ],
					[ '10 products', '30 products ', '50 products ',
							'All Products ' ] ],
			pageLength : 30,
			// data:products

			ajax : {

				url : jsonUrl,
				dataSrc : ''
			},

			columns : [
					{
						data : 'id'
												

					},
					{
						data : 'code',
						mRender : function(data, row, row) {
							return'<img src="'
									+ window.contextRoot
									+ '/resources/images/'
									+ data
									+ '.jpg" class="adminDataTableImg"/>';
						}

					},
					{

						data : 'name'

					},
					{

						data : 'brand'

					},

					{

						data : 'quantity',
						mRender : function(data, type, row) {
							if (data < 1) {

								return'<span style="color:red"> out of stock <span/>';
							}
							return data;
						}

					},
					{

						data : 'unitPrice',
						mRender : function(data, type, row) {
							return'&#8377; ' + data

						}

					},
					{
						data : 'active',
						bSortable : false,
						mRender : function(data, type, row) {
							var str = '';
							str += '<label class="switch">';
							if (data) {
								str += '<input type="checkbox" checked="checked" value="'
										+ row.id + '" />';
							} else {
								str += '<input type="checkbox" value="'
										+ row.id + '" />';
							}
							str += '<div class="slider"></div></label>';

							return str;

						}

					},
					{
						data : 'id',
						bSortable : false,
						mRender : function(data, type, row) {
							var str = '';
							str += '<a href="'+window.contextRoot+'/manage/'+ data+ '/product" class="btn btn-warning">';
							str += '<span class="glyphicon glyphicon-pencil"></span></a>';
							return str;

						}

					}

			],
			//after closing the all column we are adding bootbox for loading the table befor the ajax call
			//using the initCompletefunction so alert will work
			//for the alert bootbox while loading the table
			initComplete:function()
			{
				
				var api=this.api();
				api.$('.switch input[type="checkbox"]')
				.on(
						'change',
						function() {
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dMsg = (checked) ? 'You want to activate the product'
									: 'You want to deactivate product?';

							var value = checkbox.prop('value');

							bootbox
									.confirm({

										size : 'medium',
										title : 'Product activation and deactivation',
										message : dMsg,
										callback : function(confirmed) {
											if (confirmed) {
												console.log(value);
												var activationUrl=window.contextRoot+'/manage/product/'+value+'/activation';
												$.post(activationUrl,function(data){bootbox
													.alert({
														size : 'medium',
														title : 'information',
														message : data
																
													});
												});
												
											} else {
												checkbox.prop('checked', !checked)
											}
										}
									})
						});
			}
		});
}

//------- AdminTable ends here


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	});

	
    












