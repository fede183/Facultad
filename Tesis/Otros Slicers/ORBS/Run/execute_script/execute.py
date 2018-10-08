import sys
import psutil
import subprocess
import time

#Leer los parámetros: 1-timeout 2-programa 3-parámetros
maxElapsedTime = int(sys.argv[1][0:(len(sys.argv[1])-1)])
programPath = sys.argv[2]
parameters = sys.argv[3:]
#Inicializar el programa
#subp = subprocess.Popen(["C:\\Users\\Soifer\\Desktop\\Varios\\Pruebas\\testApplication\\testApplication\\bin\\Debug\\testApplication.exe"])
#programPath = "C:\\Users\\Camilo\\Desktop\\testApplication\\testApplication\\bin\\Debug\\testApplication.exe"

try:
	with open('output.orbs', "w") as outfile:
		l = [programPath]
		l.extend(parameters)
		subp = subprocess.Popen(l, stdout=outfile)
		p = psutil.Process(subp.pid)
		try:
			init_time = time.time()
			while True:
				#print(str(time.time() - init_time))
				if (time.time() - init_time) > maxElapsedTime:
					p.kill()
					raise RuntimeError('timeout')
				elif (p.is_running() == False):
					sys.exit(0)
			sys.exit(0)
		except Exception as e:
			sys.exit(1)
		
		# subp = subprocess.Popen(l, stdout=outfile)
		# retCode = 0
		# try:
			# p = psutil.Process(subp.pid)
			# while p.is_running():
				# if (time.time() - p.create_time()) > maxElapsedTime:
					# p.kill()
					# raise RuntimeError('timeout')
				# time.sleep(1)
			# #print("OK")
			# sys.exit(0)
		# except AttributeError:
			# sys.exit(0)
		# except psutil.NoSuchProcess:
			# sys.exit(0)
		# except Exception as e:
			# #print(str(e))
			# sys.exit(1)
		
		# V1:
		# #subp = subprocess.check_call(l, stdout=outfile)
		# subp = subprocess.Popen(l, stdout=outfile)
		# retCode = 0
		# try:
			# p = psutil.Process(subp.pid)
		# except AttributeError:
			# #print("OK FAST")
			# sys.exit(0)
		# try:
			# p.wait(timeout=maxElapsedTime)
			# retCode = subp.returncode
		# except psutil.TimeoutExpired:
			# p.kill()
			# retCode = 1
			# #print("TIMEOUT")
		# #print("OK")
		# #print(str(subp.returncode))
		# sys.exit(retCode)
except subprocess.CalledProcessError:
	#print("ERROR")
	sys.exit(1)