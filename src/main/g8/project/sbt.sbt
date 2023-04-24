Global / excludeLintKeys ++= Set(
  autoStartServer,
  evictionWarningOptions
)

ThisBuild / autoStartServer := false
ThisBuild / update / evictionWarningOptions := EvictionWarningOptions.empty
