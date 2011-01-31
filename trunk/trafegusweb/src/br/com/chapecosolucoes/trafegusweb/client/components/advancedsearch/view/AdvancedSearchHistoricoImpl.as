package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller.AdvancedSearchHistoricoImplController;
	import br.com.chapecosolucoes.trafegusweb.client.components.datafieldpt.DataFieldPT;
	import br.com.chapecosolucoes.trafegusweb.client.utils.MyDateFormatter;
	
	import mx.containers.FormItem;
	import mx.controls.TextInput;

	public class AdvancedSearchHistoricoImpl extends AdvancedSearch
	{
		public function AdvancedSearchHistoricoImpl()
		{
			super();
		}
		override protected function initializationComplete():void
		{
			super.initializationComplete();
			this.controller = new AdvancedSearchHistoricoImplController();
			this.controller.view = this;
		}
		override protected function childrenCreated():void
		{
			var formItemDataInicial:FormItem = new FormItem();
			formItemDataInicial.name = "formItemDataInicial";
			formItemDataInicial.label = "Data inicial";
			var dfDataInicial:DataFieldPT = new DataFieldPT();
			dfDataInicial.name = "dfDataInicial";
			dfDataInicial.text = MyDateFormatter.getInstance().parse(new Date());
			formItemDataInicial.addChild(dfDataInicial);
			this.form.addChild(formItemDataInicial);

			var formItemDataFinal:FormItem = new FormItem();
			formItemDataFinal.name = "formItemDataFinal";
			formItemDataFinal.label = "Data final";
			var dfDataFinal:DataFieldPT = new DataFieldPT();
			dfDataFinal.name = "dfDataFinal";
			dfDataFinal.text = MyDateFormatter.getInstance().parse(new Date());
			formItemDataFinal.addChild(dfDataFinal);
			this.form.addChild(formItemDataFinal);
<<<<<<< .mine
			
			var formItemDescricao:FormItem = new FormItem();
			formItemDescricao.name = "formItemDescricao";
			formItemDescricao.label = "Descrição";
			var txtDescricao:TextInput = new TextInput();
			txtDescricao.name = "txtDescricao";
			formItemDescricao.addChild(txtDescricao);
			this.form.addChild(formItemDescricao);
			
=======
			
			var formItemGPSDescSis:FormItem = new FormItem();
			formItemGPSDescSis.name = "formItemGPSDescSis";
			formItemGPSDescSis.label = "Posição";
			var textInputGPSDescSis:TextInput = new TextInput();
			textInputGPSDescSis.name = "textInputGPSDescSis";
			formItemGPSDescSis.addChild(textInputGPSDescSis);
			
			this.form.addChild(formItemGPSDescSis);
>>>>>>> .r337

		}
	}
}