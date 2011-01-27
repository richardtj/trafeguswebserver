package br.com.chapecosolucoes.trafegusweb.client.utils
{
	import mx.formatters.DateFormatter;

	public class MyDateFormatter
	{
		public function MyDateFormatter(singletonForce:SingletonForcer)
		{
			if (singletonForce == null)
			{
				throw new Error("Utilize o metodo parse()");
			}
			dateFormatter = new DateFormatter();
			dateFormatter.formatString = "DD/MM/YYYY JJ:NN:SS";
			timeFormatter = new DateFormatter();
			timeFormatter.formatString = "JJ:NN:SS";
		}
		private static var instance:MyDateFormatter;
		private var dateFormatter:DateFormatter;
		private var timeFormatter:DateFormatter;
		public static function getInstance():MyDateFormatter
		{
			if (instance == null)
			{
				instance = new MyDateFormatter(new SingletonForcer());
			}
			return instance
		}
		public function parse(date:Date):String
		{
			return dateFormatter.format(date);
		}
		public function parseTime(date:Date):String
		{
			return timeFormatter.format(date);
		}
	}
}

class SingletonForcer
{
}