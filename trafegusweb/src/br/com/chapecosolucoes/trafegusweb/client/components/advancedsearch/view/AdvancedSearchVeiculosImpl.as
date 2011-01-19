package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller.AdvancedSearchController;
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller.AdvancedSearchVeiculosImplController;
	
	import mx.containers.FormItem;
	import mx.controls.TextInput;

	public class AdvancedSearchVeiculosImpl extends AdvancedSearch
	{
		public function AdvancedSearchVeiculosImpl()
		{
			super();
		}
		override protected function initializationComplete():void
		{
			super.initializationComplete();
			this.controller = new AdvancedSearchVeiculosImplController();
			this.controller.view = this;
		}
		override protected function childrenCreated():void
		{
			var formItemPlaca:FormItem = new FormItem();
			formItemPlaca.name = "formItemPlaca";
			formItemPlaca.label = "Placa";
			var textInputPlaca:TextInput = new TextInput();
			textInputPlaca.name = "textInputPlaca";
			formItemPlaca.addChild(textInputPlaca);
			this.form.addChild(formItemPlaca);
			var formItemDesc:FormItem = new FormItem();
			formItemDesc.name = "formItemDesc";
			formItemDesc.label = "Descrição";
			var textInputDesc:TextInput = new TextInput();
			textInputDesc.name = "textInputDesc";
			formItemDesc.addChild(textInputDesc);
			this.form.addChild(formItemDesc);
		}
	}
}