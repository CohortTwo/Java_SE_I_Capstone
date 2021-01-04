cls
@Echo off
>nul rmdir /S /Q output

mkdir output\mlib 
mkdir output\classes 
javac -d output\classes first\FirstPackage\FirstClass.java
jar -cf output\mlib\first.jar -C output\classes .
rmdir /S /Q output\classes

mkdir output\classes
javac -d output\classes -classpath output\mlib\first.jar second\SecondPackage\SecondClass.java
jar -cf output\mlib\second.jar -C output\classes .
rmdir /S /Q output\classes
echo "-----------------------------------------------------------"
echo "Output With Classpath (Unnamed Modules)"
echo "   Compiled using -classpath and executed using -classpath "
echo "-----------------------------------------------------------"
java -cp output\mlib\* SecondPackage.SecondClass

echo "-----------------------------------------------------------"
echo "Output With ModulePath (Automatic Module naming)"
echo "   Compiled using -classpath and executed using -modulepath "
echo "------------------------------------------------------------"
java -p output\mlib\ -m second/SecondPackage.SecondClass

rmdir /S /Q output

mkdir output\mlib
mkdir output\classes
javac -d output\classes first\FirstPackage\FirstClass.java first\module-info.java
jar -cf output\mlib\first.jar -C output\classes .
rmdir /S /Q output\classes

mkdir output\classes
javac --module-path output\mlib\first.jar -d output\classes second\module-info.java second\SecondPackage\SecondClass.java
jar -cf output\mlib\second.jar -C output\classes .
rmdir /S /Q output\classes


echo "-------------------------------------------------------------"
echo "Output With Modulepath (Explicit Named Modules)"
echo "   Compiled using -modulepath and executed using -modulepath "
echo "-------------------------------------------------------------"

java -p output\mlib\first.jar;output\mlib\second.jar -m thesecond/SecondPackage.SecondClass
