from Crypto.Cipher import PKCS1_OAEP
from Crypto.PublicKey import RSA

# Load the private key
with open("private_key.pem", "rb") as f:
    private_key = RSA.import_key(f.read())

cipher_rsa = PKCS1_OAEP.new(private_key)

# Read the encrypted message from the file
with open("encrypted_message.bin", "rb") as f:
    encrypted_message = f.read()

# Decrypt the encrypted message
decrypted_message = cipher_rsa.decrypt(encrypted_message)
print(f"Decrypted message: {decrypted_message.decode()}")
