package za.co.idealogic.javaexercise;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void process(String... args) {
		final Options options = new Options();

        Option countOption = Option.builder("c")
        		.required(true)
        		.longOpt( "count" )
        		.hasArg()
        		.argName("count")
                .desc("How many times to print Hello World")
                .build();
        options.addOption(countOption);

        Option byeOption = Option.builder("b")
        		.required(false)
                .desc("Say goodbye too")
                .build();
        options.addOption(byeOption);

        final CommandLineParser parser = new DefaultParser();
        final HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            log.error(e.getMessage());
            formatter.printHelp("Java Exercise 3", options);

            System.exit(1);
            return;
        }

        final boolean bye = cmd.hasOption('b');

        if (cmd.hasOption('c')) {
        	String countStr = cmd.getOptionValue("count");
      		try {
				Integer i = Integer.parseInt(countStr);
				while (i-- > 0) {
					log.info("Hello World");
				}
			} catch (NumberFormatException e) {
				log.error("Invalid value for count variable");
				System.exit(1);
	            return;
			}
        }
        
        if(bye) {
        	log.info("Bye world");
        }
	}
}
