package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller.AdvancedSearchReferenciasImplController;
	
	import mx.containers.FormItem;
	import mx.controls.TextInput;

	public class AdvancedSearchReferenciasImpl extends AdvancedSearch
	{
		public function AdvancedSearchReferenciasImpl()
		{
			super();
		}
		override protected function initializationComplete():void
		{
			super.initializationComplete();
			this.controller = new AdvancedSearchReferenciasImplController();
			this.controller.view = this;
		}
		override protected function childrenCreated():void
		{
			var formItemReferencia:FormItem = new FormItem();
			formItemReferencia.name = "formItemReferencia";
			formItemReferencia.label = "Referência";
			var textInputReferencia:TextInput = new TextInput();
			textInputReferencia.name = "textInputReferencia";
			formItemReferencia.addChild(textInputReferencia);
			this.form.addChild(formItemReferencia);
			var formItemGrupo:FormItem = new FormItem();
			formItemGrupo.name = "formItemGrupo";
			formItemGrupo.label = "Grupo";
			var textInputGrupo:TextInput = new TextInput();
			textInputGrupo.name = "textInputGrupo";
			formItemGrupo.addChild(textInputGrupo);
			this.form.addChild(formItemGrupo);
		}
	}
}