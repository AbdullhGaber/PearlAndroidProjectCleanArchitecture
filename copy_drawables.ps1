$appRes = "c:\Users\DELL\AndroidStudioProjects\Pearl\app\src\main\res"
$dsRes = "c:\Users\DELL\AndroidStudioProjects\Pearl\design_system\src\main\res"

$copiedCount = 0
$skippedCount = 0

$excludedFiles = @("ic_launcher_background.xml", "ic_launcher_foreground.xml", "ic_launcher.xml", "ic_launcher_round.xml")

# Get all drawable directories in app
$drawableDirs = Get-ChildItem -Path $appRes -Filter "drawable*" -Directory

foreach ($dir in $drawableDirs) {
    $dirName = $dir.Name
    $targetDir = Join-Path $dsRes $dirName

    if (-not (Test-Path $targetDir)) {
        New-Item -ItemType Directory -Path $targetDir | Out-Null
    }

    $files = Get-ChildItem -Path $dir.FullName -File
    foreach ($file in $files) {
        if ($excludedFiles -contains $file.Name) {
            $skippedCount++
            continue
        }

        $targetFile = Join-Path $targetDir $file.Name
        if (-not (Test-Path $targetFile)) {
            Copy-Item -Path $file.FullName -Destination $targetFile
            $copiedCount++
        } else {
            $skippedCount++
        }
    }
}

Write-Host "Total copied: $copiedCount"
Write-Host "Total skipped/excluded: $skippedCount"
