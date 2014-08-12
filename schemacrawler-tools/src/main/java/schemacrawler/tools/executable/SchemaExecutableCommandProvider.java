package schemacrawler.tools.executable;


import schemacrawler.schemacrawler.SchemaCrawlerException;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.tools.integration.graph.GraphExecutable;
import schemacrawler.tools.integration.graph.GraphOutputFormat;
import schemacrawler.tools.options.OutputOptions;
import schemacrawler.tools.text.schema.SchemaTextExecutable;

class SchemaExecutableCommandProvider
  extends ExecutableCommandProvider
{

  public SchemaExecutableCommandProvider(final String command)
  {
    super(command, "");
  }

  @Override
  public Executable configureNewExecutable(final SchemaCrawlerOptions schemaCrawlerOptions,
                                           final OutputOptions outputOptions)
    throws SchemaCrawlerException
  {
    // Decide if the output format is a graph format
    boolean isGraph = false;
    if (outputOptions != null)
    {
      isGraph = GraphOutputFormat.isGraphOutputFormat(outputOptions
        .getOutputFormatValue());
    }

    // Create and configure executable
    final Executable executable;
    if (isGraph)
    {
      executable = new GraphExecutable(getCommand());
    }
    else
    {
      executable = new SchemaTextExecutable(getCommand());
    }

    if (schemaCrawlerOptions != null)
    {
      executable.setSchemaCrawlerOptions(schemaCrawlerOptions);
    }
    if (outputOptions != null)
    {
      executable.setOutputOptions(outputOptions);
    }

    return executable;

  }

}
