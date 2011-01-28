package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller.AdvancedSearcHistoricoImplController;
	import br.com.chapecosolucoes.trafegusweb.client.components.datafieldpt.DataFieldPT;
	
	import mx.containers.FormItem;
	import mx.controls.TextInput;

	public class AdvancedSearcHistoricoImpl extends AdvancedSearch
	{
		public function AdvancedSearcHistoricoImpl()
		{
			super();
		}
		override protected function initializationComplete():void
		{
			super.initializationComplete();
			this.controller = new AdvancedSearcHistoricoImplController();
			this.controller.view = this;
		}
		override protected function childrenCreated():void
		{
			var formItemDataInicial:FormItem = new FormItem();
			formItemDataInicial.name = "formItemDataInicial";
			formItemDataInicial.label = "Data inicial";
			var dfDataInicial:DataFieldPT = new DataFieldPT();
			dfDataInicial.name = "dfDataInicial";
			dfDataInicial.value = (new Date()) - 7;
			formItemDataInicial.addChild(dfDataInicial);
			this.form.addChild(formItemDataInicial);

			var formItemDataFinal:FormItem = new FormItem();
			formItemDataFinal.name = "formItemDataFinal";
			formItemDataFinal.label = "Data final";
			var dfDataFinal:DataFieldPT = new DataFieldPT();
			dfDataFinal.name = "dfDataFinal";
			dfDataFinal.value = new Date();
			formItemDataFinal.addChild(dfDataFinal);
			this.form.addChild(formItemDataFinal);

		}
	}
}