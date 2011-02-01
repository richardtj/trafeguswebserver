package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller.GenericAdvancedSearchImplController;
	
	import mx.controls.DataGrid;
	import mx.controls.dataGridClasses.DataGridColumn;

	public class GenericAdvancedSearchImpl extends GenericAdvancedSearch
	{
		public function GenericAdvancedSearchImpl()
		{
			super();
		}
		override protected function initializationComplete():void
		{
			super.initializationComplete();
			this.controller = new GenericAdvancedSearchImplController();
			this.controller.view = this;
		}
		override protected function childrenCreated():void
		{
			for (var i:int = 1; i < DataGrid(this.view.dataGrid).columnCount; i++)
			{ 
				var dataGridColumn:DataGridColumn = DataGrid(this.view.dataGrid).columns[i];
				
				var formItem:FormItem = new FormItem();
				formItem.name = "formItem" + dataGridColumn.dataField;
				formItem.label = dataGridColumn.headerText;
				
				var textInput:TextInput = new TextInput();
				textInput.name = "textInput" + dataGridColumn.dataField;
				formItem.addChild(textInput);
				
				this.form.addChild(formItem);
			}
		}
	}
}